@echo off
set regpath=HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Session Manager\Environment
set javahome=D:\0_0DevTools\Java\jdk
rem LPY
echo.
echo ************************************************************
echo *                                                          *
echo *                   JDK 系统环境变量设置                   *
echo *                                                          *
echo ************************************************************
echo.
echo === 准备设置环境变量: JAVA_HOME=%javahome%
echo === 注意: 如果JAVA_HOME存在,会被覆盖,此操作不可逆的,请仔细检查确认!! ===
echo.
echo === 准备设置环境变量(后面有个.): classPath=%%JAVA_HOME%%\lib\tools.jar;%%JAVA_HOME%%\lib\dt.jar;.
echo === 注意: 如果classPath存在,会被覆盖,此操作不可逆的,请仔细检查确认!! ===
echo.
echo === 准备设置环境变量: PATH=%%JAVA_HOME%%\bin
echo === 注意: PATH会追加在最前面,
echo.
set /P EN=请确认后按 回车键 开始设置!
echo.
echo.
echo.
echo.
echo === 新创建环境变量 JAVA_HOME=%javahome%
setx "JAVA_HOME" "%javahome%" -M
setx "ANDROID_ADB_SERVER_PORT" "12306" -M
setx "ANDROID_HOME" "D:\0_0DevTools\Android\SDK" -M
setx "GRADLE_HOME" "D:\0_0DevTools\Android\ASConfig\gradle" -M
setx "FLUTTER_SDK" "D:\0_0DevTools\flutter\bin" -M
setx "GRADLE_USER_HOME" "H:\0_0DevWorks\.gradle" -M
setx "ANDROID_SDK_HOME" "H:\0_0Develop\Android\AVD" -M
echo.
echo.
echo === 新创建环境变量 classPath=%%JAVA_HOME%%\lib\tools.jar;%%JAVA_HOME%%%\lib\dt.jar;.
setx "DEV_PATH" %%JAVA_HOME%%\bin;%%JAVA_HOME%%\jre\bin;%%ANDROID_HOME%%\tools;%%ANDROID_HOME%%\platform-tools;%%GRADLE_HOME%%\bin;%%ANDROID_SDK_HOME%%;%%FLUTTER_SDK%% -m
echo.
echo.
echo === 手动将 %%DEV_PATH%% 添加到 PATH 上请按任意键退出! 
echo === 手动将 %%DEV_PATH%% 添加到 PATH 上请按任意键退出! 
echo === 手动将 %%DEV_PATH%% 添加到 PATH 上请按任意键退出! 
pause>nul