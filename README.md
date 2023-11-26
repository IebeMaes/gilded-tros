# Gilded Tros Refactoring Kata

This Kata is based on the Gilded Rose Kata, originally created by Terry Hughes (http://twitter.com/TerryHughes). It is already on GitHub [here](https://github.com/NotMyself/GildedRose). See also [Bobby Johnson's description of the kata](http://iamnotmyself.com/2011/02/13/refactor-this-the-gilded-rose-kata/) and [this version with multiple languages](https://github.com/emilybache/GildedRose-Refactoring-Kata).
It was slightly rebranded by Axxes IT Consultancy, and renamed to Gilded Tros (with a wink to a local bar near the Axxes HQ ;)).

## How I solved this Kata

I solved this programming challenge in Java. 
Firstly, I added comments to understand the existing code. 
Then, I upgraded the Java version from 1.8 to 1.21.

Following that, I introduced unit tests to ensure the code's functionality remained intact while I started refactoring. 
Once all the tests were passing, I began creating subclasses for different item categories mentioned in the code.

Utilizing an ItemCategory interface, I migrated all category-specific logic to these subclasses. 
I added additional tests to verify that everything functioned correctly.

Finally, I replaced all the code within the GildedTros class with a method that retrieves the specific category class. 
This method calls two other methods to update the sellIn and quality properties respectively.

Additionally, I refined the main method in the TexttestFixture class to improve the readability of the output.