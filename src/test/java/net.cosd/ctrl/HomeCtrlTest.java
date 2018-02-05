package net.cosd.ctrl;

/*
尽管新版本的测试只比之前版本多了几行代码， 但是它更加完整地测试了
HomeController。 这次我们不是直接调用home()方法并测试它的返回值， 而是发起了
对“/”的GET请求， 并断言结果视图的名称为home。 它首先传递一个HomeController实例
到MockMvcBuilders.standaloneSetup()并调用build()来构建MockMvc实例。 然后
它使用MockMvc实例来执行针对“/”的GET请求并设置期望得到的视图名称。
 */

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

public class HomeCtrlTest {
    @Test
    public void testHomePage() throws Exception {
        HomeController ctrl = new HomeController();
        // 搭建 MockMvc
        MockMvc mockMvc = standaloneSetup(ctrl).build();
        // 预期得到 success 视图
        mockMvc.perform(get("/")).andExpect(view().name("success"));
        //assertEquals("success", ctrl.home());
    }


}

