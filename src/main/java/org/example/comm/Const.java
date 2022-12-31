package org.example.comm;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Const {
    public interface Type<T> extends BaseEnum<T>{
        enum test implements Type<test>{
            ;

            public final String desc;
            public final int code;

            test(String desc, int code) {
                this.desc = desc;
                this.code = code;
            }

            @Override
            public String getDesc() {
                return this.desc;
            }

            @Override
            public int getCode() {
                return this.code;
            }
        }
    }

    public enum gender implements Type<gender>{
        MAN("男",0),
        WOMAN("女",1);

        public final String desc;
        public final int code;

        gender(String desc, int code) {
            this.desc = desc;
            this.code = code;
        }

        @Override
        public String getDesc() {
            return this.desc;
        }

        @Override
        public int getCode() {
            return this.code;
        }

        @Override
        public String toString() {
            return desc;
        }
    }
}
