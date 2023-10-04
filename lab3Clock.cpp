class Clock{
    private:
        int hour, minute, second;

        int hms_to_sec(){
            return hour*3600 + minute*60 + second;
        }
        
        void sec_to_hms(int seconds){
            if(seconds>0){
                hour = seconds/3600;
                minute = (seconds%3600)/60;
                second = seconds%60;
            }
            else
                Clock();
        }
        
    public:
         Clock(int h, int m, int s){
            hour = h;   
            minute = m;
            second = s;
         }

        Clock(){
            Clock(0,0,0);
        }

        Clock(int seconds){
            sec_to_hms(seconds);
        }       

        int get_hour() const{
            return hour;
        }

        int get_minute() const{
            return minute;
        }
        
        int get_second() const{
            return second;
        }

        void set_hour(int h){
            if(h>= 0 && h < 24)
                hour = h;            
        }

        void set_minute(int m){
            if(m >= 0 && m < 60)
                minute = m;
        }
        void set_second(int s){
            if(s >= 0 && s < 60)
                second = s;
        }

        void increment(){
            second++;
            if(second >= 60){
                second %=60;
                minute++;
            }
            if(minute >= 60){
                minute %= 60;
                hour++;
            }
            if(hour > 23)
                hour = 0;
        }
        void decrement(){
            second--;
            if(second < 0){
                second +=60;
                minute--;
            }
            if(minute < 0){
                minute += 60;
                hour--;
            }
            if(hour < 0)
                hour = 23;
        }
        void add_seconds(int seconds){
            int sum = hms_to_sec() + seconds;
            sec_to_hms(sum);
        }

};