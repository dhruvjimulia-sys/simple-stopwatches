class Stopwatch() {
    fun start() {
		var timeLapsed = 0
		while (true) {
			clearLine()
			val (hrs, mins, secs) = convertFromSeconds(timeLapsed)
			printTime(hrs, mins, secs)
			waitFor(1000)
			timeLapsed++
		}
	}

	private fun convertFromSeconds(secs: Int): Triple<Int, Int, Int> {
		var mins = secs / 60
		val remSecs = secs % 60
		val hrs = mins / 60
		mins %= 60
		return Triple(hrs, mins, remSecs);
	}

	private fun printTime(hrs: Int, mins: Int, secs: Int) {
		val twoDigit = fun (num: Int) = (if (num < 10) "0" else "") + num
		print("${twoDigit(hrs)}:${twoDigit(mins)}:${twoDigit(secs)}")
	}

	private fun clearLine() {
		print("\b\b\b\b\b\b\b\b")
	}

	private fun waitFor(ms: Long) {
		try {
			Thread.sleep(ms);
		} catch (e: InterruptedException) {
			Thread.currentThread().interrupt();
		}
	}
}

fun main() = Stopwatch().start()
