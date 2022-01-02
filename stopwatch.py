import time
import sys

def time_convert(sec):
    mins = sec // 60
    sec = sec % 60
    hours = mins // 60
    mins = mins % 60
    return (int(hours), int(mins), int(sec))

time_lapsed = 0
while True:
    (hours, mins, sec) = time_convert(time_lapsed)
    print(f"Time Lapsed = {hours:02}:{mins:02}:{sec:02}")
    sys.stdout.write("\033[F")
    time.sleep(1)
    time_lapsed = time_lapsed + 1
