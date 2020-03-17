var stack = function () {
    this.top = -1;
    this.array = [];
    this.pushItem = function (element) {
        this.array.push(element);
        this.top += 1;
    }
    this.popItem = function () {
        if (this.top == -1) {
            console.log("Stack is empty");
        }
        else {
            this.array.pop();
            this.top -= 1;
        }
    }
}


st = new stack();
st.pushItem(20);
st.pushItem(40);
st.array;
st.popItem();
st.array;
