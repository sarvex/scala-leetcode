Get-ChildItem -Filter *.md -Recurse | Remove-Item

Get-ChildItem -Filter *.scala -Recurse | Rename-Item -NewName { $_.Directory.Name+'.scala'}
Get-ChildItem -Filter *.scala -Recurse | Move-Item -Destination { $_.Directory.Parent.FullName }

Get-ChildItem -Filter *.java -Recurse | Rename-Item -NewName { $_.Directory.Name+'.java'}
Get-ChildItem -Filter *.java -Recurse | Move-Item -Destination { $_.Directory.Parent.FullName }
