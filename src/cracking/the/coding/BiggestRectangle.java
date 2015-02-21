package cracking.the.coding;


public class BiggestRectangle {
    static int[][] graphs = { // representation of bar graph, y-axis upside down
            {1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1},
            {0, 1, 1, 0, 0, 1},
            {0, 0, 1, 0, 0, 1}
    };

    public static void main(String[] args) {
        int biggestArea = -1;

        // start with y 0 until max height
        for (int y = 0; y < graphs.length; y++) {
            int x1 = -1;
            int x2 = -1;
            // start with x 0 until max width
            for (int x = 0; x < graphs[y].length; x++) {
                if (graphs[y][x] == 1 && x1 == -1)
                    x1 = x;
                else if (graphs[y][x] == 0 && x1 != -1)
                    break;
                else
                    x2 = x;

            }
            int area = getArea(x1, x2, y);
            if (area > biggestArea) {
                biggestArea = area;
                System.out.printf("x1 %d x2 %d y %d \n", x1, x2, y);
            }
        }

        System.out.println(biggestArea);
    }

    public static int getArea(int x1, int x2, int y2) {
        return (x2 + 1 - x1) * (y2 + 1); // need to add 1 to both x2 and y2, as array index starts with 0
    }
}
