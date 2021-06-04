package com.aldi.movienjam.ui


import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.aldi.movienjam.R
import com.aldi.movienjam.ui.main.MainActivity
import com.aldi.movienjam.utils.DataDummy
import com.aldi.movienjam.utils.EspressoIdlingResource
import org.junit.*
import org.junit.runners.MethodSorters


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class MainActivityTest()  {
private val dummyMovie = DataDummy.generateDataMovieDummy()
private val dummyTvShow = DataDummy.generateDataTvShowDummy()


    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Before
    fun setup() {

        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun Test1Movie() {
        onView(withId(R.id.rv_movie))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )

    }

    @Test
    fun Test2DetailMovie(){
        onView(withId(R.id.rv_movie))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie))
            .perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                    dummyMovie.size
                )
            )
        onView(withId(R.id.rv_movie))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    2,
                    click()
                )
            )

        onView(withId(R.id.iv_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.coordinator_layout)).perform(swipeUp())
        onView(withId(R.id.collapsing)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
        pressBack()

    }

    @Test
    fun Test3TvShow() {
        onView(withId(R.id.nav_tv_show)).perform(click())
        onView(withId(R.id.rv_tv))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShow.size
            )
        )
    }

    @Test
    fun Test4DetailTv() {
        onView(withId(R.id.nav_tv_show)).perform(click())
        onView(withId(R.id.rv_tv))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
        onView(withId(R.id.rv_tv))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    2,
                    click()
                )
            )
        onView(withId(R.id.iv_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.coordinator_layout)).perform(swipeUp())
        onView(withId(R.id.collapsing)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
        pressBack()

    }

    @Test
    fun Test5MovieFav() {
        onView(withId(R.id.nav_movie)).perform(click())
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, click()
            )
        )
        onView(withId(R.id.to_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.to_favorite)).perform(click())
        pressBack()
    }

    @Test
    fun Test6TvFav() {
        onView(withId(R.id.nav_tv_show)).perform(click())
        onView(withId(R.id.rv_tv)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, click()
            )
        )
        onView(withId(R.id.to_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.to_favorite)).perform(click())
        pressBack()
    }

    @Test
    fun Test7Favorite(){
        onView(withId(R.id.nav_fav)).perform(click())
        onView(withId(R.id.rv_favorite_movie))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_movie))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        onView(withId(R.id.iv_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.coordinator_layout)).perform(swipeUp())
        onView(withId(R.id.collapsing)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
        pressBack()
    }

    @Test
    fun Test8Favorite2(){
        onView(withId(R.id.nav_fav)).perform(click())
        onView(withId(R.id.rv_favorite_movie))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_movie))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        onView(withId(R.id.to_favorite)).perform(click())

    }
}