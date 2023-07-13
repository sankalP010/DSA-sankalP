import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to represent the courses and their prerequisites
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Create an array to track the number of incoming edges for each course
        int[] incomingEdges = new int[numCourses];
        
        // Build the adjacency list and count incoming edges
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(prerequisiteCourse).add(course);
            incomingEdges[course]++;
        }
        
        // Create a queue to store nodes with no incoming edges
        Queue<Integer> queue = new LinkedList<>();
        
        // Add nodes with no incoming edges to the queue
        for (int i = 0; i < numCourses; i++) {
            if (incomingEdges[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Process the nodes until the queue is empty
        int coursesTaken = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            coursesTaken++;
            
            // Decrement the incoming edges of adjacent courses
            for (int adjCourse : graph.get(course)) {
                incomingEdges[adjCourse]--;
                
                // If an adjacent course has no more incoming edges, add it to the queue
                if (incomingEdges[adjCourse] == 0) {
                    queue.offer(adjCourse);
                }
            }
        }
        
        // If all courses have been taken, return true; otherwise, return false
        return coursesTaken == numCourses;
    }
}
