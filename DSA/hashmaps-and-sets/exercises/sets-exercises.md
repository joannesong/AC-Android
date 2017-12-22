# In-class exercises: analyze our social network

Please work through these exercises using [this stencil file](exercise/SocialNetwork.java). Complete as many as you can in class.

1. **Implement `allFriends`:** A union of two sets is the set of all things that are members of either. Here is a visual:

  ![Union](http://upload.wikimedia.org/wikipedia/commons/3/30/Venn0111.svg)
S
  `allFriends` friends should return a new set that contains all the friends in `yours` and all the friends in `mine`.

1. **Implement `mutualFriends`:** An intersection is the set of all things that are members of both sets.

    ![Intersection](http://upload.wikimedia.org/wikipedia/commons/9/99/Venn0001.svg)

  `mutualFriends` friends should return a new set that contains just the friends that are in both `yours` and `mine`.

1. **Implement `justYourFriends`:** A complement is the set of all elements that are members of one set but not another.
![Complement](http://upload.wikimedia.org/wikipedia/commons/e/e6/Venn0100.svg)

 `justYourFriends` friends should return a new set that contains just the friends that are in both `yours`. If any friends in `mine` are also in `yours`, do not add them to the set returned.

1. **Implement `justMyFriends`:** This is just like `justYourFriends` but returns only the friends in `mine` rather than `yours`. Can you think of an easy way to do this?

1. **Implement `exclusiveFriends`:** The symmetric difference is the set of things which are in either of two sets but not in their intersection.

 ![Difference](http://upload.wikimedia.org/wikipedia/commons/4/46/Venn0110.svg)

1. **Implement `yourFriendsAreMine`:** A set is a subset of another if every thing in the first set is also in the second. Here, `A` is a subset of `B`:

 ![Subset](http://upload.wikimedia.org/wikipedia/commons/b/b0/Venn_A_subset_B.svg)
