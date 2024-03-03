
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BubbleShooter extends JFrame {
    // 定义游戏界面大小
    private static final int ROWS = 9;
    private static final int COLS = 9;

    // 定义颜色列表
    private static final char[] COLORS = {'R', 'G', 'B', 'Y', 'O', 'P'};

    // 存储游戏界面的二维数组
    private char[][] board;

    // 当前射击的颜色
    private char currentColor;



    // 游戏界面的面板
    private GamePanel gamePanel;

    // 用于显示当前将要发射出去的颜色的标签
    private JLabel nextBubbleColorLabel;

    // 构造函数，初始化游戏
    public BubbleShooter() {
        setTitle("泡泡龙游戏");
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        board = new char[ROWS][COLS];
        currentColor = getRandomColor();
        initBoard();

        gamePanel = new GamePanel();
        getContentPane().add(gamePanel, BorderLayout.CENTER);


        // 创建面板，用于放置将要发射颜色的标签
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);

        // 添加将要发射颜色的标签
        nextBubbleColorLabel = new JLabel("下一个颜色：" + getColorName(currentColor));
        panel.add(nextBubbleColorLabel);

        // 添加鼠标点击监听器，用于发射气泡
        gamePanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int column = e.getX() / 50; // 根据鼠标点击的位置计算列数
                shootBubble(column, currentColor);
                nextBubbleColorLabel.setText("下一个颜色：" + getColorName(currentColor)); // 更新将要发射颜色的标签
            }
        });

        setVisible(true);
    }

    // 初始化游戏界面
    private void initBoard() {
        Random random = new Random();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = COLORS[random.nextInt(COLORS.length)];
            }
        }
    }

    private boolean checkMatches() {
        // 遍历每个格子，检查是否有匹配的气泡
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                char color = board[i][j];
                if (color != ' ') {
                    // 检查水平方向
                    if (j < COLS - 2 && board[i][j + 1] == color && board[i][j + 2] == color) {
                        return true;
                    }
                    // 检查垂直方向
                    if (i < ROWS - 2 && board[i + 1][j] == color && board[i + 2][j] == color) {
                        return true;
                    }
                    // 检查斜向（从左上到右下）
                    if (i < ROWS - 2 && j < COLS - 2 && board[i + 1][j + 1] == color && board[i + 2][j + 2] == color) {
                        return true;
                    }
                    // 检查斜向（从右上到左下）
                    if (i < ROWS - 2 && j >= 2 && board[i + 1][j - 1] == color && board[i + 2][j - 2] == color) {
                        return true;
                    }
                    //检查三角状
                    /*if (i<ROWS-1&&j>=1&&board[i+1][j-1]==color&&board[i][j-1]==color){///////
                        return true;
                    }*/
                    if (i<ROWS-1&&j>=1&&board[i+1][j-1]==color&&board[i+1][j]==color){
                        return true;
                    }
                    if (i>1&&j>1&&board[i-1][j-1]==color&&board[i-1][j]==color){
                        return true;
                    }
                    if (i>1&&j>1&&board[i-1][j-1]==color&&board[i][j-1]==color){
                        return true;
                    }


                }
            }
        }
        return false;
    }

    // 移除匹配的气泡
    private void removeMatches() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                char color = board[i][j];
                if (color != ' ') {
                    // 检查水平方向
                    if (j < COLS - 2 && board[i][j + 1] == color && board[i][j + 2] == color) {
                        board[i][j] = ' ';
                        board[i][j + 1] = ' ';
                        board[i][j + 2] = ' ';
                    }
                    // 检查垂直方向
                    if (i < ROWS - 2 && board[i + 1][j] == color && board[i + 2][j] == color) {
                        board[i][j] = ' ';
                        board[i + 1][j] = ' ';
                        board[i + 2][j] = ' ';
                    }
                    // 检查斜向（从左上到右下）
                    if (i < ROWS - 2 && j < COLS - 2 && board[i + 1][j + 1] == color && board[i + 2][j + 2] == color) {
                        board[i][j] = ' ';
                        board[i + 1][j + 1] = ' ';
                        board[i + 2][j + 2] = ' ';
                    }
                    // 检查斜向（从右上到左下）
                    if (i < ROWS - 2 && j >= 2 && board[i + 1][j - 1] == color && board[i + 2][j - 2] == color) {
                        board[i][j] = ' ';
                        board[i + 1][j - 1] = ' ';
                        board[i + 2][j - 2] = ' ';
                    }
                /*    if (i<ROWS-1&&j>=1&&board[i+1][j-1]==color&&board[i][j+1]==color){///////////
                        board[i][j]=' ';
                        board[i+1][j-1]=' ';
                        board[i][j+1]=' ';
                    }*/
                     if (i<ROWS-1&&j>=1&&board[i+1][j-1]==color&&board[i+1][j]==color){
                         board[i][j]=' ';
                         board[i+1][j-1]=' ';
                         board[i+1][j]=' ';
                     }
                     if (i>1&&j>1&&board[i-1][j-1]==color&&board[i-1][j]==color){
                         board[i][j]=' ';
                         board[i-1][j-1]=' ';
                         board[i-1][j]=' ';
                     }
                     if (i>1&&j>1&&board[i-1][j-1]==color&&board[i][j-1]==color){
                         board[i][j]=' ';
                         board[i-1][j-1]=' ';
                         board[i][j-1]=' ';
                     }


                }
            }
        }
    }

    // 下落气泡
    private void dropBubbles() {
        for (int j = 0; j < COLS; j++) {
            for (int i = ROWS - 1; i >= 0; i--) {
                if (board[i][j] == ' ') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (board[k][j] != ' ') {
                            board[i][j] = board[k][j];
                            board[k][j] = ' ';
                            break;
                        }
                    }
                }
            }
        }
    }

    // 射击气泡
    private void shootBubble(int column, char color) {
        if (column < 0 || column >= COLS) {
            return;
        }

        // 将气泡放置在最底部空白处
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == ' ') {
                board[i][column] = color;
                break;
            }
        }


        while (checkMatches()) {
            // 移除匹配的气泡
            removeMatches();
            // 下落气泡
            dropBubbles();
        }

        currentColor = getRandomColor();

        repaint(); // 重新绘制游戏界面
    }


    private char getRandomColor() {
        Random random = new Random();
        return COLORS[random.nextInt(COLORS.length)];
    }


    private String getColorName(char colorChar) {
        switch (colorChar) {
            case 'R':
                return "红色";
            case 'G':
                return "绿色";
            case 'B':
                return "蓝色";
            case 'Y':
                return "黄色";
            case 'O':
                return "橙色";
            case 'P':
                return "粉色";
            default:
                return "未知颜色";
        }
    }

    // 游戏面板类
    class GamePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int cellSize = 50; // 每个格子的大小
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    int x = j * cellSize;
                    int y = i * cellSize;
                    char color = board[i][j];
                    // 绘制气泡
                    if (color != ' ') {
                        g.setColor(getColor(color));
                        g.fillOval(x, y, cellSize, cellSize);//填充颜色
                        g.setColor(Color.BLACK);
                        g.drawOval(x, y, cellSize, cellSize);//描边
                    }
                }
            }

                }


            }



        // 根据气泡颜色字符返回对应的颜色
        private Color getColor(char colorChar) {
            switch (colorChar) {
                case 'R':
                    return Color.RED;
                case 'G':
                    return Color.GREEN;
                case 'B':
                    return Color.BLUE;
                case 'Y':
                    return Color.YELLOW;
                case 'O':
                    return Color.ORANGE;
                case 'P':
                    return Color.PINK;
                default:
                    return Color.WHITE;
            }
        }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {//依次执行事件并立即重画
            public void run() {
                new BubbleShooter();
            }
        });
    }
}
