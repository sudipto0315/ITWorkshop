count=5

while [ $count -gt 0 ]; do
echo $count
((count--))
done

echo "Blastoff!"