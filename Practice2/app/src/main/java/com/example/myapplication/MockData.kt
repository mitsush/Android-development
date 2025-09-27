package com.example.myapplication

object MockData {
    fun getPosts(): List<Post> = listOf(
        Post(
            id = 1,
            title = "Mountains sunset",
            content = "Description",
            imageUrl = "https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=800&h=600&fit=crop",
            likeCount = 15
        ),
        Post(
            id = 3,
            title = "Mountain Adventure",
            content = "3",
            imageUrl = "https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=800&h=600&fit=crop",
            likeCount = 23
        ),
        Post(
            id = 4,
            title = "City Lights",
            content = "4",
            imageUrl = "https://images.unsplash.com/photo-1514565131-fce0801e5785?w=800&h=600&fit=crop",
            likeCount = 31
        ),
        Post(
            id = 5,
            title = "Fresh Flowers",
            content = "34",
            imageUrl = "https://images.unsplash.com/photo-1490750967868-88aa4486c946?w=800&h=600&fit=crop",
            likeCount = 12
        ),
        Post(
            id = 6,
            title = "Ocean Waves",
            content = "7",
            imageUrl = "https://images.unsplash.com/photo-1505142468610-359e7d316be0?w=800&h=600&fit=crop",
            likeCount = 19
        ),
        Post(
            id = 7,
            title = "Delicious Meal",
            content = "T5",
            imageUrl = "https://images.unsplash.com/photo-1551782450-a2132b4ba21d?w=800&h=600&fit=crop",
            likeCount = 7
        ),
        Post(
            id = 8,
            title = "Furry Friend",
            content = "5",
            imageUrl = "https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?w=800&h=600&fit=crop",
            likeCount = 42
        )
    )
}