package cat.xojan.random2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import com.google.firebase.analytics.FirebaseAnalytics


class PlayerActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener  {

    private val RECOVERY_REQUEST = 1

    lateinit var mYoutubeView: YouTubePlayerView
    lateinit var mFirebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        setContentView(R.layout.activity_player)
        initViews()
    }

    private fun initViews() {
        mYoutubeView = findViewById(R.id.youtube_view) as YouTubePlayerView
        mYoutubeView.initialize(BuildConfig.YOUTUBE_API_KEY, this)
    }

    override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, player: YouTubePlayer?,
                                         wasRestored: Boolean) {
        player!!.setFullscreen(true)
        player.setShowFullscreenButton(false)
        if (!wasRestored) {
            val country = intent.getParcelableExtra<Country>("extra_country")
            player.loadVideo(country.videoId)
            logEvent(country.title)
        }
    }

    override fun onInitializationFailure(provider: YouTubePlayer.Provider?,
                                         errorReason: YouTubeInitializationResult?) {
        if (errorReason!!.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show()
        } else {
            val error = String.format(getString(R.string.player_error), errorReason.toString())
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            mYoutubeView.initialize(BuildConfig.YOUTUBE_API_KEY, this);
        }
    }

    private fun logEvent(title: String) {
        val bundle = Bundle()
        bundle.putString("video_selected", title)
        mFirebaseAnalytics.logEvent("select_country", bundle)
    }
}
