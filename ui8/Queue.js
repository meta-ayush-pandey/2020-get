var queue = function () {
    this.array = [];
    this.enqueue = function (element) {
        this.array.push(element);
    }
    this.dequeue = function () {
        if (this.array.length == 0) {
            console.log("Queue is empty");
        }
        else {
            this.array.shift();
        }
    }
}


st = new queue();
st.enqueue(20);
st.enqueue(40);
st.array;
st.dequeue();
st.array;
