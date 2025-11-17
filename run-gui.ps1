# Set JavaFX path
$env:JAVA_FX = "$env:USERPROFILE\Downloads\openjfx-25.0.1_windows-x64_bin-sdk\javafx-sdk-25.0.1\lib"

# Change to project folder
cd 'C:\Users\reyaj\Desktop\Management_Application-IOOP2025'

# Compile
Write-Host "Compiling..." -ForegroundColor Green
javac --module-path $env:JAVA_FX --add-modules javafx.controls *.java

if ($?) {
    Write-Host "Compilation successful! Running GUI..." -ForegroundColor Green
    # Run
    java --module-path $env:JAVA_FX --add-modules javafx.controls gui
} else {
    Write-Host "Compilation failed. Check errors above." -ForegroundColor Red
}
