public class Solution {
    class Course {
        List<Integer> edgeTo;
        public Course() {
            edgeTo = new ArrayList<Integer>();
        }
        public void addEdge(int e) {
            edgeTo.add(e);
        }
        public Iterable<Integer> edge() {
            return edgeTo;
        }
    }
    Stack<Integer> stack;
    boolean[] onStack;
    boolean[] marked;
    Course[] courses;
    boolean cycle;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        cycle = false;
        stack = new Stack<Integer>();
        onStack = new boolean[numCourses];
        marked = new boolean[numCourses];
        courses = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course();
        }
        for (int[] pair : prerequisites) {
            int pre = pair[1];
            int post = pair[0];
            courses[pre].addEdge(post);
        }
        for (int i = 0; i < numCourses; i++) {
            dfs(i);
            if (cycle) {
                return new int[0];
            }
        }
        int[] rst = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            rst[i] = stack.pop();
        }
        return rst;
        
    }
    private void dfs(int i) {
        if (onStack[i]) {
            cycle = true;
        }
        if (cycle || marked[i]) {
            return;
        }
        marked[i] = true;
        onStack[i] = true;
        for (int j : courses[i].edge()) {
            dfs(j);
        }
        onStack[i] = false;
        stack.push(i);
    }
}
