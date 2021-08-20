package com.bw.mvvm_core.cmds;

/**
 * @ClassName BindCommand
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/17 16:41
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class BindCommand<T,R> {
    private Action action;
    private ActionTwo actionTwo;
    private Function function;
    private FunctionTwo functionTwo;

    public BindCommand(Action action) {
        this.action = action;
    }

    public BindCommand(Function function) {
        this.function = function;
    }

    public void execute(){
        if (action!=null){
            action.Execute();
        }
    }

    public void executeTwo(T param){
        if (actionTwo!=null){
            actionTwo.Execute(param);
        }
    }

    public R funExecute(){
        if (function!=null){
            return (R) function.Execute();
        }
        return null;
    }

    public R execute(R param){
        if (functionTwo!=null){
            return (R) functionTwo.Execute(param);
        }
        return null;
    }
}
