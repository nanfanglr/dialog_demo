package com.rui.dialog_demo;

/**
 * Created by rui on 2019/11/8
 */
public class BuilderFactory {
    private String cpu;
    private String screen;
    private String hhd;
    private String board;

    public BuilderFactory(String cpu, String screen, String hhd, String board) {
        this.cpu = cpu;
        this.screen = screen;
        this.hhd = hhd;
        this.board = board;
    }

    @Override
    public String toString() {
        return "显示器：" + this.screen + " CPU：" + this.cpu + " 主板：" + this.board + " 硬盘：" + this.hhd;
    }

    public static class Builder {
        private String cpu;
        private String screen;
        private String hhd;
        private String board;

        public Builder withCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder withScreen(String screen) {
            this.screen = screen;
            return this;
        }

        public Builder withHhd(String hhd) {
            this.hhd = hhd;
            return this;
        }

        public Builder withBoard(String board) {
            this.board = board;
            return this;
        }

        public BuilderFactory build() {
            return new BuilderFactory(this.cpu, this.screen, this.hhd, this.board);
        }

    }
}
