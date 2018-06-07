package net.cosd.ctrl;

/*
尽管新版本的测试只比之前版本多了几行代码， 但是它更加完整地测试了
HomeController。 这次我们不是直接调用home()方法并测试它的返回值， 而是发起了
对“/”的GET请求， 并断言结果视图的名称为home。 它首先传递一个HomeController实例
到MockMvcBuilders.standaloneSetup()并调用build()来构建MockMvc实例。 然后
它使用MockMvc实例来执行针对“/”的GET请求并设置期望得到的视图名称。
 */

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import net.cosd.vo.Spittle;
import net.cosd.service.SpittleRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeCtrlTest {
//    @Test
//    public void testHomePage() throws Exception {
//        HomeController ctrl = new HomeController();
//        // 搭建 MockMvc
//        MockMvc mockMvc = standaloneSetup(ctrl).build();
//        // 对"/"实行get请求 预期得到 success 视图
//        mockMvc.perform(get("/")).andExpect(view().name("success"));
//        assertEquals("success", ctrl.home());
//    }

//    @Test
//    public void shouldShowRecentSpittles() throws Exception {
//        List<Spittle> expectedSpittles = createSpittleList(20);
//        // Mock Repository
//        SpittleRepository mockRepository = mock(SpittleRepository.class);
//        when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
//                .thenReturn(expectedSpittles);
//        SpittleController controller = new SpittleController(mockRepository, null);
//
//        MockMvc mockMvc = standaloneSetup(controller)
//                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
//                .build();
//        mockMvc.perform(get("/spittles"))
//                .andExpect(view().name("spittles"))
//                .andExpect(model().attributeExists("spittleList"))
//                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
//
//
//    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i=0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }
//
//    // 通过路径参数接受输入
//    @Test
//    public void testSpittle() throws Exception {
//        Spittle expectSpittle = new Spittle("hello", new Date());
//        SpittleRepository mockRepository = mock(SpittleRepository.class);
//        when(mockRepository.findOne(12345))
//                .thenReturn(expectSpittle);
//        SpittleController controller = new SpittleController(mockRepository);
//        MockMvc mockMvc = standaloneSetup(controller)
//                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
//                .build();
//        mockMvc.perform(get("/spittles/12345"))
//                .andExpect(view().name("spittles"))
//                .andExpect(model().attributeExists("spittle"))
//                .andExpect(model().attribute("spittle", expectSpittle));
//    }



}

