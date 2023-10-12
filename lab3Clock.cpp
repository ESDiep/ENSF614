#include "lab3Clock.h"
//Constructors
Clock::Clock(int h, int m, int s){
    if(h < 0 || h > 23 || m <0 || m >59 || s <0 || s>59){
        hour = 0;
        minute = 0;
        second = 0;
    }else{
        hour = h; 
        minute = m;
        second = s;
    }
   
}

Clock::Clock(){
    hour = 0;
    minute = 0;
    second = 0;
}

Clock::Clock(int seconds){
            Clock::sec_to_hms(seconds);
}

int Clock::hms_to_sec(){
            return hour*3600 + minute*60 + second;
        }
        
void Clock::sec_to_hms(int seconds){
            if(seconds>0){
                hour = seconds/3600;
                if(hour == 24)
                    hour = 0;
                minute = (seconds%3600)/60;
                second = seconds%60;
            }
            else{
                hour = 0;
                minute = 0;
                second =0;
            }
                
}
        
int Clock::get_hour() const{
            return hour;
}

int Clock::get_minute() const{
            return minute;
}
        
int Clock::get_second() const{
            return second;
}

void Clock::set_hour(int h){
            if(h>= 0 && h < 24)
                hour = h;  
                    
}

void Clock::set_minute(int m){
            if(m >= 0 && m < 60)
                minute = m;
            
}

void Clock::set_second(int s){
            if(s >= 0 && s < 60)
                second = s;
            
}

void Clock::increment(){
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

void Clock::decrement(){
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
void Clock::add_seconds(int seconds){
            int sum = hms_to_sec() + seconds;
            sec_to_hms(sum);
}
