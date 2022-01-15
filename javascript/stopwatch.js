class Stopwatch {
  convertSeconds(secs) {
    let mins = Math.floor(secs / 60);
    secs %= 60;
    const hours = Math.floor(mins / 60);
    mins %= 60;
    return [hours, mins, secs];
  }
  
  startStopwatch() {
    let timeLapsed = 0;
    setInterval(() => {
      this.clearLine();
      const time = this.convertSeconds(timeLapsed);
      this.printTime(time);
      timeLapsed+=180;
    }, 1000)
  }

  printTime(time) {
    const twoDigit = (num) => (num < 10 ? "0" : "") + num;
    process.stdout.write(
      `${twoDigit(time[0])}:${twoDigit(time[1])}:${twoDigit(time[2])}`
    );
  }

  clearLine() {
    process.stdout.clearLine();
    process.stdout.cursorTo(0);
  }
}

const stopwatch = new Stopwatch();
stopwatch.startStopwatch();