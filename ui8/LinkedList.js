// Singly Linked List Implementation.
var node = function (element) {
    this.item = element;
    this.next = null;
}

var linkedList = function () {
    let head = null;
    this.size = 0;
    this.addItem = function (element) {
        var newNode = new node(element);
        if (head == null) {
            head = newNode;
            this.size += 1;
        }
        else {
            var traverseNode = head;
            while (traverseNode.next != null) {
                traverseNode = traverseNode.next;
            }
            traverseNode.next = newNode;
        }
    }
    this.deleteItem = function (element) {
        var elementFound = false;
        var traverseNode = head;
        var previousNode = null;
        while (traverseNode != null) {
            if (traverseNode.item == element) {
                if (previousNode == null) {
                    head = traverseNode.next;
                }
                else {
                    previousNode.next = traverseNode.next;
                }
                elementFound = true;
                this.size -= 1;
                break;
            }
            previousNode = traverseNode;
            traverseNode = traverseNode.next;
        }
        if (elementFound == true) {
            console.log("Element Deleted");
        }
        else {
            console.log("Element not found");
        }
    }
    this.dispalyList = function () {
        var traverseNode = head;
        while (traverseNode != null) {
            console.log(traverseNode.item);
            traverseNode = traverseNode.next;
        }
    }

}

sl = new linkedList();
sl.addItem(10);
sl.addItem(20);
sl.dispalyList();
sl.deleteItem(20);
sl.dispalyList();

