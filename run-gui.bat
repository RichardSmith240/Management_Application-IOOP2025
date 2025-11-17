@echo off
REM Batch script to compile and run gui.java with JavaFX
setlocal enabledelayedexpansion

set JAVA_FX=%USERPROFILE%\Downloads\openjfx-25.0.1_windows-x64_bin-sdk\javafx-sdk-25.0.1\lib
cd /d C:\Users\reyaj\Desktop\Management_Application-IOOP2025

echo Compiling gui.java...
javac --module-path "%JAVA_FX%" --add-modules javafx.controls *.java

if %ERRORLEVEL% EQU 0 (
    echo.
    echo Compilation successful! Launching GUI...
    echo.
    java --module-path "%JAVA_FX%" --add-modules javafx.controls gui
) else (
    echo.
    echo Compilation failed. Check errors above.
    echo.
    pause
)
