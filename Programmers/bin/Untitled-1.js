const util = require("util");
const str = `VAR A:INT; SET A=100;
FUNC foo {
  VAR B:INT; SET B=20;
  FUNC bar {
    VAR C:INT; SET C=5;
      FUNC cop {
        VAR D:INT; SET D=30;
        ADD B,D;
    }
    SUB B,C;
  }
  ADD A,B;
}
SUB A,100;
`;

const str2 = `VAR A:INT; SET A=100; 
FUNC foo {
  VAR B:INT; SET B=20; 
  ADD A,B; 
}
SUB A,100;
`;

const str3 = `const str = "FUNC foo {
  VAR B:INT; SET B=20; 
`;

let token = [];

function tokenizer(str) {
  let tempToken = str.split(/\n/);
  let token_result = [];
  for (t of tempToken) {
    if (/\s*VAR.*/.test(t)) {
      let var_set = t.split(/\;\s/);
      token_result.push(var_set[0].trim());
      token_result.push(var_set[1].trim().replace(";", ""));
    } else {
      token_result.push(t.trim().replace(";", ""));
    }
  }
  return token_result;
}

function Lexer(token) {
  let exp, name, type, length, value, operand1, operand2, scope;
  const _bst = new BST();
  if (token?.startsWith("VAR")) {
    exp = token.slice(3);
    name = exp.split(":")[0].replace(" ", "");
    type = exp.split(":")[1].replace(" ", "");
    length = String(name.length);
    return {
      element: "DeclVar",
      attributes: {
        name: name,
        type: type,
        length: length,
      },
    };
  } else if (token?.startsWith("SET")) {
    exp = token.slice(3);
    name = exp.split("=")[0].replace(" ", "");
    value = exp.split("=")[1].replace(" ", "");
    return {
      element: "Assign",
      attributes: {
        name: name,
        value: value,
      },
    };
  } else if (token?.startsWith("ADD") || token?.startsWith("SUB")) {
    exp = token.slice(3);
    operand1 = exp.split(",")[0].replace(" ", "");
    operand2 = exp.split(",")[1].replace(" ", "");
    return {
      element: "Command",
      attributes: {
        name: token.slice(0, 3),
        operand1: operand1,
        operand2: operand2,
      },
    };
  } else if (token?.startsWith("FUNC")) {
    exp = token.slice(4);
    name = exp.replace("{", "").replace(" ", "");
    return {
      element: "DeclFunc",
      attributes: {
        name: name,
        scope: _bst,
      },
    };
  } else if (token === "}" || token === "") {
    return token;
  } else {
    return { element: "ERROR", attributes: "올바른 언어 형식이 아닙니다." };
  }
}

class Stack {
  constructor() {
    this.arr = [];
    this.index = 0;
  }
  push(item) {
    this.arr[this.index++] = item;
  }
  pop() {
    if (this.index <= 0) return null;
    const result = this.arr[--this.index];
    return result;
  }
  reverse() {
    return this.arr.reverse();
  }
}

class LeftBSTNode {
  constructor(element, attributes = null) {
    this.element = element;
    this.attributes = attributes;
  }
}
class RightBSTNode {
  constructor(element, left = null, right = null) {
    this.element = element;
    this.left = left;
    this.right = right;
  }
}

class BST {
  constructor() {
    this.root = null;
  }

  get() {
    return this.root;
  }
  add(data) {
    const node = this.root;
    if (node === null) {
      this.root = new RightBSTNode("Code");
      this.root.left = new LeftBSTNode(data.element, data.attributes);
      return;
    } else {
      function addTree(node) {
        if (node.left === null) {
          node.left = new LeftBSTNode(data.element, data.attributes);
          return;
        } else if (node.right === null) {
          let newNode = new RightBSTNode("Code");
          newNode.left = new LeftBSTNode(data.element, data.attributes);
          node.right = newNode;
          return;
        } else {
          return addTree(node.right);
        }
      }

      return addTree(node);
    }
  }

  elementByAttribute(attr) {
    const node = this.root;
    let attrArr = [];

    if (node === null) {
      return attrArr;
    } else {
      function searchTree(node) {
        if (node) {
          if (node.left !== null) {
            if (
              node.left.element === attr &&
              node.left.element !== "DeclFunc"
            ) {
              attrArr.push(node.left);
              return searchTree(node.right);
            } else if (
              node.left.element !== attr &&
              node.left.element !== "DeclFunc"
            ) {
              return searchTree(node.right);
            } else if (
              node.left.element === attr &&
              node.left.element === "DeclFunc"
            ) {
              attrArr.push(node.left);
              searchTree(node.right);
              return searchTree(node.left.attributes.scope);
            } else if (
              node.left.element !== attr &&
              node.left.element === "DeclFunc"
            ) {
              searchTree(node.right);
              return searchTree(node.left.attributes.scope);
            }
            return searchTree(node.right);
          }
        } else {
          return;
        }
      }
      searchTree(node);

      return attrArr;
    }
  }

  countByClass(attr) {
    return this.elementByAttribute(attr).length;
  }

  stringify() {
    if (this.root.left.element === "ERROR") {
      return `ERROR: "올바른 언어 형식이 아닙니다."`;
    } else {
      return util
        .inspect(this.root, false, null, true)
        .replace("BSTNode", "")
        .replace("Left", "")
        .replace("Right", "")
        .replace("  ", " ");
    }
  }
}

function handleFunction(funcStack) {
  let rootFunc = funcStack.pop();
  let notFunc = new Stack();

  while (funcStack.length !== 0) {
    let popItem = funcStack.pop();

    if (popItem.element !== "DeclFunc") {
      notFunc.push(popItem);
    } else {
      rootFunc.attributes.scope = rootFunc.attributes.scope.root;
      popItem.attributes.scope.add(rootFunc);
      rootFunc = popItem;
      notFunc = notFunc.reverse();
      while (notFunc.length != 0) {
        let putFuncItem = notFunc.pop();
        rootFunc.attributes.scope.add(putFuncItem);
      }
    }
  }
  if (funcStack.length === 0) {
    rootFunc.attributes.scope = rootFunc.attributes.scope.root;
  }
  return rootFunc;
}

function ASMParser(token) {
  let i = 0;
  const bst = new BST();
  const errBst = new BST();
  let isFunc = false;
  let funcBST = new Stack();
  let funcStack = new Stack();
  let func_cnt = 0;
  while (i < token.length) {
    let lexer_tok = Lexer(token[i]);
    if (lexer_tok === "") {
      break;
    }
    if (lexer_tok.element === "ERROR") {
      errBst.add(lexer_tok);
      return errBst;
    }
    if (lexer_tok.element === "DeclFunc") {
      func_cnt += 1;
      funcBST.push(lexer_tok);
      isFunc = true;
    } else if (isFunc === true) {
      if ((funcBST.index != 0) & (funcStack.index == 0)) {
        let popFunc = funcBST.pop();

        popFunc.attributes.scope.add(lexer_tok);
        funcBST.push(popFunc);
      } else if (func_cnt !== 0) {
        funcStack.push(lexer_tok);
      }

      if (i + 1 < token.length && token[i + 1] === "}") {
        func_cnt -= 1;
        isFunc = false;
      }
    } else if (lexer_tok === "}" && func_cnt !== 0) {
      let tempFunc = funcBST.pop();
      funcStack.push(tempFunc);
      isFunc = true;
    } else if (lexer_tok === "}" && func_cnt === 0) {
      let tempFunc = funcBST.pop();
      funcStack.push(tempFunc);
      let finalFuncResult = handleFunction(funcStack.reverse());
      isFunc = false;
      bst.add(finalFuncResult);
    } else if (isFunc === false) {
      bst.add(lexer_tok);
    }

    i += 1;
  }
  return bst;
}
function main() {
  token = tokenizer(str);
  const asm = ASMParser(token);
  console.log(asm.stringify());
  console.log(asm.elementByAttribute("Assign"));
  console.log(asm.countByClass("Assign"));
}

main();