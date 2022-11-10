package com.progen.projects.chessy.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public abstract class SimpleMinEngine {

    // -------------------------------
    // STATICS
    // -------------------------------

    public interface ILogger {
        void debug(String s);
        void info(String s);
        void error(String s);
    }

    public interface IKeyboard {

        boolean isKeyPressed(int keyCode);

        default boolean A(){
            return isKeyPressed(KeyEvent.VK_A);
        }

        default boolean B(){
            return isKeyPressed(KeyEvent.VK_B);
        }

        default boolean C(){
            return isKeyPressed(KeyEvent.VK_C);
        }

        default boolean D(){
            return isKeyPressed(KeyEvent.VK_D);
        }

        default boolean E(){
            return isKeyPressed(KeyEvent.VK_E);
        }

        default boolean F(){
            return isKeyPressed(KeyEvent.VK_F);
        }

        default boolean G(){
            return isKeyPressed(KeyEvent.VK_G);
        }

        default boolean H(){
            return isKeyPressed(KeyEvent.VK_H);
        }

        default boolean I(){
            return isKeyPressed(KeyEvent.VK_I);
        }

        default boolean J(){
            return isKeyPressed(KeyEvent.VK_J);
        }

        default boolean K(){
            return isKeyPressed(KeyEvent.VK_K);
        }

        default boolean L(){
            return isKeyPressed(KeyEvent.VK_L);
        }

        default boolean M(){
            return isKeyPressed(KeyEvent.VK_M);
        }

        default boolean N(){
            return isKeyPressed(KeyEvent.VK_N);
        }

        default boolean O(){
            return isKeyPressed(KeyEvent.VK_O);
        }

        default boolean P(){
            return isKeyPressed(KeyEvent.VK_P);
        }

        default boolean Q(){
            return isKeyPressed(KeyEvent.VK_Q);
        }

        default boolean R(){
            return isKeyPressed(KeyEvent.VK_R);
        }

        default boolean S(){
            return isKeyPressed(KeyEvent.VK_S);
        }

        default boolean T(){
            return isKeyPressed(KeyEvent.VK_T);
        }

        default boolean U(){
            return isKeyPressed(KeyEvent.VK_U);
        }

        default boolean V(){
            return isKeyPressed(KeyEvent.VK_V);
        }

        default boolean W(){
            return isKeyPressed(KeyEvent.VK_W);
        }

        default boolean X(){
            return isKeyPressed(KeyEvent.VK_X);
        }

        default boolean Y(){
            return isKeyPressed(KeyEvent.VK_Y);
        }

        default boolean Z(){
            return isKeyPressed(KeyEvent.VK_Z);
        }

        default boolean NUM_0(){
            return isKeyPressed(KeyEvent.VK_0);
        }

        default boolean NUM_1(){
            return isKeyPressed(KeyEvent.VK_1);
        }

        default boolean NUM_2(){
            return isKeyPressed(KeyEvent.VK_2);
        }

        default boolean NUM_3(){
            return isKeyPressed(KeyEvent.VK_3);
        }

        default boolean NUM_4(){
            return isKeyPressed(KeyEvent.VK_4);
        }

        default boolean NUM_5(){
            return isKeyPressed(KeyEvent.VK_5);
        }

        default boolean NUM_6(){
            return isKeyPressed(KeyEvent.VK_6);
        }

        default boolean NUM_7(){
            return isKeyPressed(KeyEvent.VK_7);
        }

        default boolean NUM_8(){
            return isKeyPressed(KeyEvent.VK_8);
        }

        default boolean NUM_9(){
            return isKeyPressed(KeyEvent.VK_9);
        }

        default boolean ENTER(){
            return isKeyPressed(KeyEvent.VK_ENTER);
        }

        default boolean SPACE(){
            return isKeyPressed(KeyEvent.VK_SPACE);
        }

        default boolean BACK_SPACE(){
            return isKeyPressed(KeyEvent.VK_BACK_SPACE);
        }

        default boolean BACK_ESCAPE(){
            return isKeyPressed(KeyEvent.VK_ESCAPE);
        }

        default boolean LEFT(){
            return isKeyPressed(KeyEvent.VK_LEFT);
        }

        default boolean RIGHT(){
            return isKeyPressed(KeyEvent.VK_RIGHT);
        }

        default boolean UP(){
            return isKeyPressed(KeyEvent.VK_UP);
        }

        default boolean DOWN(){
            return isKeyPressed(KeyEvent.VK_DOWN);
        }

    }

    public interface IMouse {

        float x();
        float y();

        boolean leftPressed();
        boolean midPressed();
        boolean rightPressed();

    }

    public interface IPencil {

        void setColor(Color c);

        void drawPixel(float x, float y);

        void drawLine(float x1, float y1, float x2, float y2);

        void drawRectangle(float x, float y, float width, float height);

        void fillRectangle(float x, float y, float width, float height);

        void drawRoundRectangle(float x, float y, float width, float height, float edge);

        void fillRoundRectangle(float x, float y, float width, float height, float edge);

        void drawCircle(float x, float y, float radius);

        void fillCircle(float x, float y, float radius);

        void drawOval(float x, float y, float width, float height);

        void fillOval(float x, float y, float width, float height);

        void drawImage(BufferedImage img, float x, float y, float width, float height);

        void fillScreen();

        void drawString(String s, float x, float y);

    }

    public static abstract class LevelLogger implements ILogger {

        public static final int DEBUG = 1;
        public static final int INFO = 2;
        public static final int ERROR = 3;
        public static final int NONE = 4;

        private int level = NONE;

        protected abstract void doDebug(String s);
        protected abstract void doInfo(String s);
        protected abstract void doError(String s);

        @Override
        public final void debug(String s) {
            if(level <= DEBUG){
                doDebug(s);
            }
        }

        @Override
        public final void info(String s) {
            if(level <= INFO){
                doInfo(s);
            }
        }

        @Override
        public final void error(String s) {
            if(level <= ERROR){
                doError(s);
            }
        }

        public final void setLevel(int level) {
            this.level = level;
        }
    }

    public static class ConsoleLogger extends LevelLogger {

        @Override
        protected void doDebug(String s) {
            System.out.println(s);
        }

        @Override
        protected void doInfo(String s) {
            System.out.println(s);
        }

        @Override
        protected void doError(String s) {
            System.err.println(s);
        }
    }

    private static class GraphicsPencil implements IPencil {

        private final Canvas canvas;
        private Graphics g;

        public GraphicsPencil(Canvas canvas) {
            this.canvas = canvas;
        }

        public void setGraphics(Graphics g) {
            this.g = g;
        }

        @Override
        public void setColor(Color c) {
            g.setColor(c);
        }

        @Override
        public void drawPixel(float x, float y) {
            g.drawLine((int)x, (int)y, (int)x, (int)y);
        }

        @Override
        public void drawLine(float x1, float y1, float x2, float y2) {
            g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
        }

        @Override
        public void drawRectangle(float x, float y, float width, float height) {
            g.drawRect((int)x, (int)y, (int)width, (int)height);
        }

        @Override
        public void fillRectangle(float x, float y, float width, float height) {
            g.fillRect((int)x, (int)y, (int)width, (int)height);
        }

        @Override
        public void drawRoundRectangle(float x, float y, float width, float height, float edge) {
            g.drawRoundRect((int)x, (int)y, (int)width, (int)height, (int)edge, (int)edge);
        }

        @Override
        public void fillRoundRectangle(float x, float y, float width, float height, float edge) {
            g.fillRoundRect((int)x, (int)y, (int)width, (int)height, (int)edge, (int)edge);
        }

        @Override
        public void drawCircle(float x, float y, float radius) {
            float dia = radius * 2;
            g.drawOval((int)(x - radius), (int)(y - radius), (int)dia, (int)dia);
        }

        @Override
        public void fillCircle(float x, float y, float radius) {
            float dia = radius * 2;
            g.fillOval((int)(x - radius), (int)(y - radius), (int)dia, (int)dia);
        }

        @Override
        public void drawOval(float x, float y, float width, float height) {
            g.drawOval((int)x, (int)y, (int)width, (int)height);
        }

        @Override
        public void fillOval(float x, float y, float width, float height) {
            g.fillOval((int)x, (int)y, (int)width, (int)height);
        }

        @Override
        public void drawImage(BufferedImage img, float x, float y, float width, float height) {
            g.drawImage(img, (int)x, (int)y, (int)width, (int)height, null);
        }

        @Override
        public void fillScreen() {
            g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }

        @Override
        public void drawString(String s, float x, float y) {
            g.drawString(s, (int)x, (int)y);
        }
    }

    private class SimpleKeyboard extends KeyAdapter implements IKeyboard {
        private static final int NUM_KEYS = KeyEvent.KEY_LAST + 1;
        private final boolean[] keys = new boolean[NUM_KEYS];

        @Override
        public boolean isKeyPressed(int keyCode) {
            if(keyOutRange(keyCode)) throw new NullPointerException("Number [" + keyCode + "] is outside range (0-" + NUM_KEYS + ")!");
            return keys[keyCode];
        }

        @Override
        public void keyPressed(KeyEvent e) {
            setKey(e.getKeyCode(), true);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            setKey(e.getKeyCode(), false);
        }

        private void setKey(int code, boolean state){
            if(keyOutRange(code)){
                log.error("Unknown keycode: [" + code + "]!");
            }
            else {
                keys[code] = state;
            }
        }

        private boolean keyOutRange(int i){
            return (i < 0 || i >= NUM_KEYS);
        }
    }

    private class SimpleMouse extends MouseAdapter implements IMouse {
        private float x, y;
        private boolean left, mid, right;

        @Override
        public void mousePressed(MouseEvent e) {
            setButton(e.getButton(), true);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            setButton(e.getButton(), false);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            x = e.getX();
            y = e.getY();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            x = e.getX();
            y = e.getY();
        }

        private void setButton(int btn, boolean state){
            if(btn == 1){
                left = state;
            }
            else if(btn == 2){
                mid = state;
            }
            else if(btn == 3){
                right = state;
            }
            else {
                log.error("Unknown mouse button: [" + btn + "]!");
            }
        }

        @Override
        public float x() {
            return x;
        }

        @Override
        public float y() {
            return y;
        }

        @Override
        public boolean leftPressed() {
            return left;
        }

        @Override
        public boolean midPressed() {
            return mid;
        }

        @Override
        public boolean rightPressed() {
            return right;
        }
    }

    private class MyWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            closeRequested = true;
        }
    }


    // -------------------------------
    // VARIABLES
    // -------------------------------
    protected final ILogger log;
    protected final IKeyboard keyboard;
    protected final IMouse mouse;
    private final float fps;
    private boolean printFps = false;
    private boolean running = false;

    // Window
    private final JFrame frame;
    private final Canvas canvas;
    private final GraphicsPencil pencil;
    private boolean closeRequested;

    public SimpleMinEngine(String title, int width, int height, float fps) {
        this.log = initLogger();
        SimpleKeyboard simpleKeyboard = new SimpleKeyboard();
        SimpleMouse simpleMouse = new SimpleMouse();
        this.fps = fps;

        this.keyboard = simpleKeyboard;
        this.mouse = simpleMouse;


        this.frame = new JFrame(title);
        this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.frame.setResizable(true);
        this.frame.addWindowListener(new MyWindowListener());

        Dimension dim = new Dimension(width, height);

        this.canvas = new Canvas();
        this.canvas.setPreferredSize(dim);

        this.canvas.addKeyListener(simpleKeyboard);
        this.canvas.addMouseListener(simpleMouse);
        this.canvas.addMouseMotionListener(simpleMouse);

        this.pencil = new GraphicsPencil(canvas);

        this.frame.add(canvas);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
    }

    public final void start() {
        if(running) return;
        running = true;

        show();
        Thread engineThread = new Thread(this::run);
        engineThread.start();
    }

    public final void stop() {
        if(!running) return;
        running = false;
    }

    protected LevelLogger initLogger(){
        return new ConsoleLogger();
    }

    protected abstract void init();
    protected abstract void onShutdown();
    protected abstract void update();
    protected abstract void render(IPencil pencil);

    private void run(){
        init();

        long lastTime = System.nanoTime();
        double ns = fps / 1000000000;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;

        while(running && !isCloseRequested()){
            long now = System.nanoTime();
            delta += (now - lastTime) * ns;
            lastTime = now;

            boolean updated = false;

            while(delta >= 1){
                update();
                if(!running) return;
                if(printFps) updates++;
                delta--;

                updated = true;
            }

            if(updated){
                draw();
            }

            if(printFps) {
                frames++;

                if(System.currentTimeMillis() - timer > 1000){
                    timer += 1000;
                    log.debug("UPDATES: " + frames + " - FPS: " + updates);
                    frames = 0;
                    updates = 0;
                }
            }
        }

        close();
        onShutdown();
    }

    public void draw(){
        BufferStrategy bs = canvas.getBufferStrategy();

        if(bs == null){
            canvas.createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        pencil.setGraphics(g);

        render(pencil);

        g.dispose();
        bs.show();
    }

    private void show(){
        this.frame.setVisible(true);
    }

    private void close(){
        this.frame.dispose();
    }

    private boolean isCloseRequested() {
        return closeRequested;
    }

    public final void setLogLevel(int level) {
        ((LevelLogger)log).setLevel(level);
    }

    public final void doPrintFps(){
        this.printFps = true;
    }

}
