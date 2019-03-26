package com.example.activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiApplicationTests {

    @Test
    public void contextLoads() {
        ProcessEngine en = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = en.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment().addClasspathResource("processes/demo1.bpmn").deploy();
        RuntimeService runtimeService = en.getRuntimeService();
        ProcessInstance myProcess_1 = runtimeService.startProcessInstanceByKey("myProcess_2");
        TaskService taskService = en.getTaskService();
        List<Task> list = taskService.createTaskQuery().processInstanceId(myProcess_1.getId()).list();
        for (Task task : list) {
            System.out.println(task.getName());
        }
    }

}
