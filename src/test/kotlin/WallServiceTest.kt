import WallService.posts
import org.junit.Assert.assertEquals
import org.junit.Test

class WallServiceTest {

    @Test
    fun add() {
        // arrange
        var postTest = Post(
            text = "bbb"
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
            text = "aaa"
        )
        var postTestNew = Post(
            text = "ccc",
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
            text = "aaa"
        )
        var postTestNew = Post(
            text = "ccc"
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
