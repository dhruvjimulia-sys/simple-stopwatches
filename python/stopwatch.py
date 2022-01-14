import time
import sys

def convert_secs(sec):
    mins = sec // 60
    sec = sec % 60
    hours = mins // 60
    mins = mins % 60
    return (int(hours), int(mins), int(sec))

def clear_line():
    sys.stdout.write("\033[F")

if __name__ == '__main__':
    time_lapsed = 0
    while True:
        (hours, mins, sec) = convert_secs(time_lapsed)
        print(f"Time lapsed = {hours:02}:{mins:02}:{sec:02}")
        clear_line()
        time.sleep(1)
        time_lapsed = time_lapsed + 1
