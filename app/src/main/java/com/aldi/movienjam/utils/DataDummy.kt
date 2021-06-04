package com.aldi.movienjam.utils


import com.aldi.movienjam.data.source.local.entity.MovieEntity
import com.aldi.movienjam.data.source.local.entity.TvShowEntity
import com.denzcoskun.imageslider.models.SlideModel
import java.util.*

object DataDummy {

    fun generateDataMovieDummy(): List<MovieEntity> {
        val listMovie = ArrayList<MovieEntity>()

        listMovie.add(
            MovieEntity(
                movieId = 1,
                title = "A Star Is Born",
                overview = "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
                releaseDate = "05/10/2018 (US)",
                posterPath = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/wqtaHWOEZ3rXDJ8c6ZZShulbo18.jpg"
            )
        )

        listMovie.add(
            MovieEntity(
                movieId = 2,
                title = "Alita: Battle Angel",
                overview = "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
                releaseDate = "14/02/2019 (US)",
                posterPath = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/aQXTw3wIWuFMy0beXRiZ1xVKtcf.jpg"
            )
        )

        listMovie.add(
            MovieEntity(
                movieId = 3,
                title = "Aquaman",
                overview = "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm\\'s half-human, half-Atlantean brother and true heir to the throne.",
                releaseDate = "21/12/2018 (US)",
                posterPath = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/4IWnPqNu34zY4ku3LQJw56MIHFc.jpg"
            )
        )

        listMovie.add(
            MovieEntity(
                movieId = 4,
                title = "Bohemian Rhapsody",
                overview = "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock \\'n\\' roll band Queen in 1970. Hit songs become instant classics. When Mercury\\'s increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                releaseDate = "02/11/2018 (US)",
                posterPath = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/xcaSYLBhmDzJ6P14bcKe0KTh3QV.jpgc"
            )
        )

        listMovie.add(
            MovieEntity(
                movieId = 5,
                title = "Cold Pursuit",
                overview = "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son\\'s murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking\\'s associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                releaseDate = "08/02/2019 (US)",
                posterPath = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/XAvFHWmWjBeJUQEHBbCcXvzdDZ.jpg"
            )
        )

        listMovie.add(
            MovieEntity(
                movieId = 6,
                title = "Creed II",
                overview = "Between personal obligations and training for his next big fight against an opponent with ties to his family\\'s past, Adonis Creed is up against the challenge of his life.",
                releaseDate = "21/11/2018 (US)",
                posterPath = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/7568G5PAdQweNfTiuwzlssOxueB.jpg"
            )
        )

        listMovie.add(
            MovieEntity(
                movieId = 7,
                title = "Robin Hood",
                overview = "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                releaseDate = "21/11/2018 (US)",
                posterPath = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/heyvaoVLGC8lcB4FFoz65EBI8xF.jpg"
            )
        )

        listMovie.add(
            MovieEntity(
                movieId = 8,
                title = "Glass",
                overview = "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                releaseDate = "18/01/2019 (US)",
                posterPath = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/ngBFDOsx13sFXiMweDoL54XYknR.jpg"
            )
        )

        listMovie.add(
            MovieEntity(
                movieId = 9,
                title = "How to Train Your Dragon: The Hidden World",
                overview = "Ketika Hiccup memenuhi mimpinya untuk menciptakan utopia naga yang damai, penemuan Toothless 'dari pasangan yang tak teruji dan sukar ditangkap membuat Night Fury menjauh. Ketika bahaya meningkat di rumah dan pemerintahan Hiccup sebagai kepala desa diuji, baik naga dan pengendara harus membuat keputusan yang mustahil untuk menyelamatkan jenis mereka.",
                releaseDate = "22/02/2019 (US)",
                posterPath = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/h3KN24PrOheHVYs9ypuOIdFBEpX.jpg"
            )
        )

        listMovie.add(
            MovieEntity(
                movieId = 10,
                title = "Avengers: Infinity War",
                overview = "Karena Avengers dan sekutunya terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh seorang pahlawan, bahaya baru telah muncul dari bayangan kosmik: Thanos. Seorang lalim penghujatan intergalaksi, tujuannya adalah untuk mengumpulkan semua enam Batu Infinity, artefak kekuatan yang tak terbayangkan, dan menggunakannya untuk menimbulkan kehendak memutar pada semua realitas. Segala sesuatu yang telah diperjuangkan oleh Avengers telah berkembang hingga saat ini - nasib Bumi dan keberadaannya sendiri tidak pernah lebih pasti.",
                releaseDate = "27/04/2018 (US)",
                posterPath = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/kbGO5mHPK7rh516MgAIJUQ9RvqD.jpg"
            )
        )

        return listMovie
    }

    fun generateDataTvShowDummy(): List<TvShowEntity> {
        val listTvShow = ArrayList<TvShowEntity>()

        listTvShow.add(
            TvShowEntity(
                tvShowId = 1,
                name = "The Arrow",
                overview = "Panah adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow",
                firstAirDate = "Oktober 10, 2012",
                posterPath = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/elbLQbocvW9vwrHRjYTSjXr5BX5.jpg"
            )
        )

        listTvShow.add(
            TvShowEntity(
                tvShowId = 2,
                name = "Doom Patrol",
                overview = "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                firstAirDate = "Februari 15, 2019",
                posterPath = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/sAzw6I1G9JUxm86KokIDdQeWtaq.jpg"
            )
        )

        listTvShow.add(
            TvShowEntity(
                tvShowId = 3,
                name = "Family Guy",
                overview = "Seri animasi animasi Freakin 'Sweet yang sakit, terpelintir, dan salah, menampilkan petualangan keluarga Griffin yang disfungsional. Peter yang kikuk dan Lois yang sudah lama menderita memiliki tiga anak. Stewie (bayi yang brilian tetapi sadis yang bertekad membunuh ibunya dan mengambil alih dunia), Meg (yang tertua, dan merupakan gadis yang paling tidak populer di kota) dan Chris (anak tengah, dia tidak terlalu cerdas tetapi memiliki hasrat untuk film ). Anggota terakhir keluarga itu adalah Brian - anjing yang bisa bicara dan lebih dari sekadar hewan peliharaan, ia menjaga Stewie, sementara menghirup Martinis dan memilah-milah masalah hidupnya sendiri.",
                firstAirDate = "Januari 31, 1999",
                posterPath = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/q3E71oY6qgAEiw6YZIHDlHSLwer.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/hnK5vODlS1OIIF3Sw6T0RQyt0K3.jpg"
            )
        )

        listTvShow.add(
            TvShowEntity(
                tvShowId = 4,
                name = "Aksi & Petualangan, Drama, Sci-fi & Fantasy",
                overview = "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                firstAirDate = "Maret 17, 2017",
                posterPath = "https://image.tmdb.org/t/p/original/27qjQrakpmFxRsgi8tErkP5z9mv.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/60TVyGnT1niDkwvKkPHuMGsJ2U5.jpg"
            )
        )

        listTvShow.add(
            TvShowEntity(
                tvShowId = 5,
                name = "NCIS",
                overview = "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                firstAirDate = "September 23, 2003",
                posterPath = "https://image.tmdb.org/t/p/original/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/ms8XxpJwTPYaUcbwhO2kJS6SGVM.jpg"
            )
        )

        listTvShow.add(
            TvShowEntity(
                tvShowId = 6,
                name = "The Flash",
                overview = "Setelah akselerator partikel menyebabkan badai aneh, Penyelidik CSI Barry Allen disambar petir dan jatuh koma. Beberapa bulan kemudian dia terbangun dengan kekuatan kecepatan super, memberinya kemampuan untuk bergerak melalui Central City seperti malaikat penjaga yang tak terlihat. Meskipun awalnya senang dengan kekuatan barunya, Barry terkejut menemukan bahwa dia bukan satu-satunya manusia meta yang diciptakan setelah ledakan akselerator - dan tidak semua orang menggunakan kekuatan baru mereka untuk kebaikan. Barry bermitra dengan S.T.A.R. Lab dan mendedikasikan hidupnya untuk melindungi yang tidak bersalah. Untuk saat ini, hanya beberapa teman dekat dan rekan yang tahu bahwa Barry secara harfiah adalah manusia tercepat, tetapi tidak lama sebelum dunia mengetahui apa yang menjadi Barry Allen ... The Flash.",
                firstAirDate = "Oktober 7, 2014",
                posterPath = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/rkRqvadAVWzdnrS6bdcUAyJtfpy.jpg"
            )
        )

        listTvShow.add(
            TvShowEntity(
                tvShowId = 7,
                name = "The Simpsons",
                overview = "Bertempat di Springfield, kota rata-rata di Amerika, pertunjukan ini berfokus pada kejenakaan dan petualangan sehari-hari keluarga Simpson; Homer, Marge, Bart, Lisa dan Maggie, serta ribuan pemain virtual. Sejak awal, serial ini telah menjadi ikon budaya pop, menarik ratusan selebriti menjadi bintang tamu. Acara ini juga menjadi terkenal karena satirnya yang tak kenal takut terhadap kehidupan politik, media, dan Amerika secara umum.",
                firstAirDate = "Desember 16, 1989",
                posterPath = "https://image.tmdb.org/t/p/original/uRWC5aO421FF3eUxo0OHh9YRo9o.jpg",
                backdropPath = "https://image.tmdb.org//t/p/original/hpU2cHC9tk90hswCFEpf5AtbqoL.jpg"
            )
        )

        listTvShow.add(
            TvShowEntity(
                tvShowId = 8,
                name = "Gotham",
                overview = "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka.",
                firstAirDate = "September 22, 2014",
                posterPath = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/l0U4mNs2vp65AAbfH8v2ymij8T5.jpg"
            )
        )

        listTvShow.add(
            TvShowEntity(
                tvShowId = 9,
                name = "Grey's Anatomy",
                overview = "Ikuti kehidupan pribadi dan profesional sekelompok dokter di Rumah Sakit Gray Sloan Memorial di Seattle.",
                firstAirDate = "Maret 27, 2005",
                posterPath = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/jnsvc7gCKocXnrTXF6p03cICTWb.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/ym20NYY99jNH0OzSg4TgLLGsQF9.jpg"
            )
        )

        listTvShow.add(
            TvShowEntity(
                tvShowId = 10,
                name = "Hanna",
                overview = "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                firstAirDate = "Maret 28, 2019",
                posterPath = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5nSSkcM3TgpllZ7yTyBOQEgAX36.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/ofjZbud67zO2wxQ48VgMVnkECQu.jpg"
            )
        )

        return listTvShow
    }

    fun generateImageSliderDummy(): List<SlideModel> {
        val listSlider = ArrayList<SlideModel>()

        listSlider.add(
            SlideModel(
                "https://image.tmdb.org/t/p/original/9KKT8qPAII0VJMpviThOTMLN0Wt.jpg",
                "Robin Hood"
            )
        )
        listSlider.add(
            SlideModel(
                "https://image.tmdb.org//t/p/original/hpU2cHC9tk90hswCFEpf5AtbqoL.jpg",
                "The Simpsons"
            )
        )
        listSlider.add(
            SlideModel(
                "https://image.tmdb.org/t/p/original/shROD2YqREzo4TuonTsTVnnjpPC.jpg",
                "Spider-Man"
            )
        )
        listSlider.add(
            SlideModel(
                "https://image.tmdb.org/t/p/original/xOdA6paXYAWURfNNdYk7Oz62mxA.jpg",
                "The Walking Dead"
            )
        )
        listSlider.add(
            SlideModel(
                "https://image.tmdb.org/t/p/original/hTnMOqUxYWSXqggzlY13NATnuTv.jpg",
                "Supergirl"
            )
        )

        return listSlider
    }
}