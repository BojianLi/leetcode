class MyQueue {
    Stack<Integer> front = new Stack<Integer>();
    Stack<Integer> back = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        back.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (front.isEmpty()) {
            fromBackToFront();
        }
        front.pop();
    }

    // Get the front element.
    public int peek() {
        if (front.isEmpty()) {
            fromBackToFront();
        }
        return front.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return front.isEmpty() && back.isEmpty();
    }
    private void fromBackToFront() {
        while (!back.isEmpty()) {
            front.push(back.pop());
        }
    }
}
