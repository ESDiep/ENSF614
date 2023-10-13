#ifndef Lab3CLOCK_H
#define LAB3CLOCK_H

class Clock{
    private:
        int hour, minute, second;
        int hms_to_sec();
        void sec_to_hms(int seconds);
        

    public:
        Clock();
        Clock(int seconds);
        Clock(int h, int m, int s);

        int get_hour() const;
        int get_minute() const;
        int get_second() const;

        void set_hour(int h);
        void set_minute(int m);
        void set_second(int s);

        void increment();
        void decrement();
        void add_seconds(int seconds);

};

#endif