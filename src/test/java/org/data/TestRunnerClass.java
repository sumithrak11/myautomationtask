package org.data;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Sumi\\Eclipse\\TestLink1\\src\\test\\resources\\Features", tags="@login,@CreateTodo,@loginAgain,@DeleteTodos")
public class TestRunnerClass {

}
