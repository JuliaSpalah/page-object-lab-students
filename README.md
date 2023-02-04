# page-object-lab-students

1. Implement following test cases using Page object pattern with Chain of Responsibility pattern 

Test #0
1. Go to the https://demo.opencart.com/
2. Click on 'Brands' at the bottom of the page
3. Check that following brands exists on page [Apple,Canon,Hewlett-Packard,HTC,Palm,Sony]

Test #1
1. Go to the https://demo.opencart.com/
2. Click on 'My account' icon
3. Click on 'Register' button
4. Fill form with valid values
5. Check that you was redirected to new page with title 'Welcome'

Test #2
1. Go to the https://demo.opencart.com/
2. Hower over Desktops from top menu
3. Click on Show All Desktops
4. Check that value in Show dropdown is 10
5. Check that value in Sort By is Default
6. Check that 10 products display on page
7. Select 25 from Show dropdown
8. Check that 12 products now dispayed
9. Check that text 'Showing 1 to 12 of 12 (1 Pages)' displays on the bottom of the page

Test #3
1. Go to the https://demo.opencart.com/
2. Hower over Desktops from top menu
3. Click on Show All Desktops
4. Select 'Name (A - Z)' from Sort by dropdown
5. Check that products were sorted correctly
6. Select 'Price (Low > High)' from Sort by dropdown
7. Check that products were sorted correctly

Test #4
1. Go to the https://demo.opencart.com/
2. On the main page check that current currency is $ (change to $ id not)
3. Click on the Iphone
4. Check that price 123.20
5. Change currency to euro
6. Chekk that price 106.04
7. Change currency to Pound Sterling
8. Check that price 95.32

Test #5
1. Go to the https://demo.opencart.com/
2. Click on the Cameras
3. Check that 2 cameras exist on page
4. Check that Canon EOS 5D has old price 122.00
5. Check that Canon EOS 5D has new price 98.00
6. Check that Nikon D300 has ex.rate 80.00
