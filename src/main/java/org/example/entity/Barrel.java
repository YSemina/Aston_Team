package org.example.entity;
public class Barrel implements Comparable<Barrel>{
    private Integer volume;
    private String content;
    private String made;

    // Builder Pattern

    public static class Builder {
        private Integer volume;
        private String content;
        private String made;

        public Barrel.Builder volume(Integer volume) {
            this.volume = volume;
            return this;
        }

        public Barrel.Builder content(String content) {
            this.content = content;
            return this;
        }

        public Barrel.Builder made(String made) {
            this.made = made;
            return this;
        }

        public Barrel build() {
            return new Barrel(this);
        }
    }

    public Barrel(Barrel.Builder builder) {
        this.volume = builder.volume;
        this.content = builder.content;
        this.made = builder.made;
    }

    // Геттеры и compareTo для сортировки
    public Integer getVolume() {
        return volume;
    }

    @Override
    public int compareTo(Barrel other) {
        System.out.println(this.volume+this.content+this.made);
        System.out.println(other.volume+other.content+other.made);
        System.out.println((this.content+this.made+this.volume).compareTo(other.content+other.made+other.volume)+"\n");
        return (this.content+this.made+this.volume).compareTo(other.content+other.made+other.volume);
    }

    @Override
    public String toString() {
        return content+","+made+","+volume;
    }
}
