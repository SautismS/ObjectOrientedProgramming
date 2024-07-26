import javax.swing.*;
import java.awt.*;

// 绘制挂人图示的面板类
public class HangmanCanvas extends JPanel {
    private int triesLeft; // 剩余尝试次数

    // 设置剩余尝试次数
    public void setTriesLeft(int triesLeft) {
        this.triesLeft = triesLeft;
        repaint(); // 重新绘制面板
    }

    // 绘制组件
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawHangman(g); // 绘制挂人图示
    }

    // 绘制挂人图示
    private void drawHangman(Graphics g) {
        int baseX = 20;
        int baseY = 200;

        g.setColor(Color.GRAY);
        g.fillRect(baseX - 40, baseY, 200, 5); // 绘制横线
        g.fillRect(baseX + 0, baseY - 160, 5, 160); // 绘制竖线
        g.fillRect(baseX + 0, baseY - 150, 120, 5); // 绘制横线
        g.fillRect(baseX + 98, baseY - 150, 5, 32); // 绘制绳子

        if (triesLeft <= 6) {
            g.setColor(Color.BLUE);
            g.fillOval(baseX + 85, baseY - 120, 30, 30); // 绘制头部
        }
        if (triesLeft <= 5) {
            g.drawLine(baseX + 100, baseY - 90, baseX + 100, baseY - 80); // 绘制脖子
        }
        if (triesLeft <= 4) {
            g.drawLine(baseX + 100, baseY - 80, baseX + 80, baseY - 60); // 绘制左臂
        }
        if (triesLeft <= 3) {
            g.drawLine(baseX + 100, baseY - 80, baseX + 120, baseY - 60); // 绘制右臂
        }
        if (triesLeft <= 2) {
            g.drawLine(baseX + 100, baseY - 90, baseX + 100, baseY - 50); // 绘制身体
        }
        if (triesLeft <= 1) {
            g.drawLine(baseX + 100, baseY - 50, baseX + 80, baseY - 30); // 绘制左腿
        }
        if (triesLeft <= 0) {
            g.drawLine(baseX + 100, baseY - 50, baseX + 120, baseY - 30); // 绘制右腿
        }
    }
}
