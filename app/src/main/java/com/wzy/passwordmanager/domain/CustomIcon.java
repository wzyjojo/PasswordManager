package com.wzy.passwordmanager.domain;

/**
 * Created by lmejojo on 2016/5/9 0009.
 */
public class CustomIcon {
    private int iconShape;
    private int roundSize;
    private int border;
    private int textSize;
    private boolean textBold;

    public int getIconShape() {
        return iconShape;
    }

    public void setIconShape(int iconShape) {
        this.iconShape = iconShape;
    }

    public int getRoundSize() {
        return roundSize;
    }

    public void setRoundSize(int roundSize) {
        this.roundSize = roundSize;
    }

    public int getBorder() {
        return border;
    }

    public void setBorder(int border) {
        this.border = border;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public boolean isTextBold() {
        return textBold;
    }

    public void setTextBold(boolean textBold) {
        this.textBold = textBold;
    }
}
