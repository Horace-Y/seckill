package org.seckill.enums;

/**
 * 使用枚举表述常量数据字段
 */
public enum SeckillStatEnum {
    SUCCESS(1,"success"),
    END(0, "end"),
    REPEAT_KILL(-1, "Repeat kill"),
    INNER_ERROR(-2, "System error"),
    DATA_REWRITE(-3,"Data tampering");


    private int state;
    private String stateInfo;

    SeckillStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SeckillStatEnum stateOf(int index){
        for(SeckillStatEnum state : values()){
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }
}
