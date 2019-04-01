package com.zyz.shopping.enums;

public enum BookTypeEnum {
    EDUCATION(1, "教育"),
    NOVEL(2, "小说"),
    LITERATURE(3, "文艺"),
    YOUTH_LITERATURE(4, "青春文学"),
    HUMANITY(5, "人文社科"),
    ECONOMIC(6, "经管"),
    ENCOURAGEMENT(7, "励志"),
    LIFE(8, "生活"),
    ORIGINAL_EDITION(9, "原版"),
    SCIENCE_FICTION(10, "科幻");


    private Integer id;
    private String name;

    BookTypeEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
