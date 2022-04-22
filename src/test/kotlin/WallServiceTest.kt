import WallService.posts
import org.junit.Assert.assertEquals
import org.junit.Test

class WallServiceTest {

    @Test
    fun add() {
        // arrange
        var postTest = Post(
            Post.Copyright(),
            Post.Comment(),
            Post.Repost(),
            text = "bbb",
            Post.Donut(Post.Limiter()),
            Post.View(),
            Post.Like(),
            Post.PostSource(),
            emptyArray<Post>(),
            Post.Geo(Post.Geo.Place())
        )
        // act
        val result = WallService.add(post = postTest)

        // assert
        assertEquals(3, result.id)
        assertEquals(3, posts.size)
    }

    @Test
    fun updateTrue() {
        // arrange
        var postTestOld = Post(
            Post.Copyright(),
            Post.Comment(),
            Post.Repost(),
            text = "aaa",
            Post.Donut(Post.Limiter()),
            Post.View(),
            Post.Like(),
            Post.PostSource(),
            emptyArray<Post>(),
            Post.Geo(Post.Geo.Place())
        )
        var postTestNew = Post(
            Post.Copyright(),
            Post.Comment(),
            Post.Repost(),
            text = "ccc",
            Post.Donut(Post.Limiter()),
            Post.View(),
            Post.Like(),
            Post.PostSource(),
            emptyArray<Post>(),
            Post.Geo(Post.Geo.Place()),
            id = 1
        )
        // act
        println(postTestOld.text)
        val add = WallService.add(post = postTestOld)
        val result = WallService.update(newPost = postTestNew)
        println(postTestOld.text)

        // assert
        assertEquals(true, result)
    }

    @Test
    fun updateFalse() {
        // arrange
        var postTestOld = Post(
            Post.Copyright(),
            Post.Comment(),
            Post.Repost(),
            text = "aaa",
            Post.Donut(Post.Limiter()),
            Post.View(),
            Post.Like(),
            Post.PostSource(),
            emptyArray<Post>(),
            Post.Geo(Post.Geo.Place())
        )
        var postTestNew = Post(
            Post.Copyright(),
            Post.Comment(),
            Post.Repost(),
            text = "ccc",
            Post.Donut(Post.Limiter()),
            Post.View(),
            Post.Like(),
            Post.PostSource(),
            emptyArray<Post>(),
            Post.Geo(Post.Geo.Place())
        )
        // act
        println(postTestOld.text)
        val add = WallService.add(post = postTestOld)
        val result = WallService.update(newPost = postTestNew)
        println(postTestOld.text)

        // assert
        assertEquals(false, result)
    }
}
