package com.minglaihan.tools;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

public class Exit extends Application {

private List<Activity> activityList = new LinkedList<Activity>(); 
private static Exit instance;

            private Exit()
            {
            }
             //单例模式中获取唯一的MyApplication实例 
             public static Exit getInstance()
             {
                            if(null == instance)
                          {
                             instance = new Exit();
                          }
                 return instance;             
             }
             //添加Activity到容器中
             public void addActivity(Activity activity)
             {
                            activityList.add(activity);
             }
             //遍历所有Activity并finish
             public void exit()
             {
                          for(Activity activity:activityList)
                         {
                           activity.finish();
                         }
                           System.exit(0);
            }
}
