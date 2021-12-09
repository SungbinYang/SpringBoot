package me.sungbin.springtestdemo.sample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(OutputCaptureExtension.class)
@WebMvcTest(SampleController.class)
class SampleControllerTest {

    @MockBean
    SampleService mockSampleService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void hello(CapturedOutput capturedOutput) throws Exception {
        when(mockSampleService.getName()).thenReturn("robert");

        mockMvc.perform(get("/hello"))
                .andExpect(content().string("hellorobert"));

        assertThat(capturedOutput.toString()).contains("holoman").contains("skip");
    }
}