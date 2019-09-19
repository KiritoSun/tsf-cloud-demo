package com.zt.test;

import com.zt.entity.EntityHandle;
import com.zt.entity.User;
import com.zt.enums.HandleCode;
import com.zt.util.JSONUtil;
import org.junit.Test;

/**
 * 测试json
 */
public class JsonTest {

    /**
     * 测试对象转json
     */
    @Test
    public void fun1() {
        User user = new User()
                .setUId("u001")
                .setUName("jack")
                .setUPassword("123456")
                .setUSex("男")
                .setUPhone("13100978956");
        EntityHandle entityHandle = new EntityHandle();
        entityHandle.setEntity(JSONUtil.beanToString(user));
        entityHandle.setHandleCode(HandleCode.SAVE);
        String msg = JSONUtil.beanToString(entityHandle);
        EntityHandle handle = JSONUtil.stringToBean(msg, EntityHandle.class);
        User user1 = JSONUtil.stringToBean(handle.getEntity(), User.class);
        System.out.println(user1);
    }

}