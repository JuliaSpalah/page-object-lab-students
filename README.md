# page-object-lab-students

1. Implement following test cases using Page object pattern with Chain of Responsibility pattern 

Test #1
1. Go to the https://demo.opencart.com/
2. Click on 'My account' icon
3. Click on 'Register' button
4. Fill form with valid values
5. Check that messege "Your Account Has Been Created!" appears


Test #2
1. Go to the https://demo.opencart.com/
2. Click on 'My account' icon
3. Click on 'Register' button
4. Fill all fields except 'First Name'
5. Check that message "First Name must be between 1 and 32 characters!" appears


Test #3
1. Go to the https://demo.opencart.com/
2. Click on 'My account' icon
3. Click on 'Login' button
4. Enter already registered email and password
5. Click 'Login' button
5. Check that "My Account" title appears on the left menu

Test #4
1. Go to the https://demo.opencart.com/
2. Click on 'My account' icon
3. Login to application
4. From top menu select 'Components' -> 'Monitors'
5. Click 'Add to Wish List' button for Apple Cinema 30" and Samsung SyncMaster 941BW
6. Click on 'My wish list on the top of the page'
7. Check that 2 items exist in your wish list

Test #5
1. Go to the https://demo.opencart.com/
2. On the main page check that current currency is $ (change to $ id not)
3. Click on the Iphone
4. Check that price 123.20
5. Change currency to euro
6. Chekk that price 106.04
7. Change currency to Pound Sterling
8. Check that price 95.32

Test #6
1. Go to the https://demo.opencart.com/
2. Click on the Cameras
3. Check that 2 cameras exist on page
4. Check that Canon EOS 5D has old price 122.00
5. Check that Canon EOS 5D has new price 98.00
6. Check that Nikon D300 has ex.rate 80.00
