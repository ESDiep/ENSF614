/*
 *  lab1exe_B.cpp
 *  ENSF 614 Lab 1, exercise B
 *  Created by Mahmood Moussavi
 *  Completed by: Sieu Diep
 */

#include <iostream>
#include <cmath>
using namespace std;

const double G = 9.8;   /* gravitation acceleration 9.8 m/s^2 */
const double PI = 3.141592654;

void create_table(double v);
double Projectile_travel_time(double a, double v);
double Projectile_travel_distance(double a, double v);
double degree_to_radian(double d);

int main(void)
{
    double velocity;
    
    cout << "Please enter the velocity at which the projectile is launched (m/sec): ";
    cin >> velocity;
    
    if(!cin)  // means if cin failed to read
    {
        cout << "Invlid input. Bye...\n";
        exit(1);
    }
    
    while (velocity < 0 )
    {
        cout << "\nplease enter a positive number for velocity: ";
        cin >> velocity;
        if(!cin)
        {
            cout << "Invlid input. Bye...";
            exit(1);
        }
    }
    
    create_table(velocity);
    return 0;
}


void create_table(double v){
    double distance = 0, time = 0, radian = 0;

    //cout<<"Angle  \t" << "t  \t" << "d \n";
    //cout << "(deg)  \t" << "sec  \t" << "m \n";
    printf("%6s \t %6s \t %s \n","Angle","t","d");
    printf("%6s \t %6s \t %s \n","(deg)","sec","m");

    for(int angle = 0; angle <= 90; angle += 5){
       radian = degree_to_radian(angle);
       distance = Projectile_travel_distance(radian,v);
       time = Projectile_travel_time(radian,v);
       
       //cout<< angle << setw(5) "\t" << time << setw(5)<< "\t" << distance << endl;
       //cout<< "%0.3d \t %0.3d \t %0.3d" << angle << time << distance << endl;
       printf("%6d \t %6.3f \t %.3f \n", angle, time, distance);
    }
}

double Projectile_travel_time(double a, double v){    
    double time = 2*v*sin(a)/G;
    return time;
}

double Projectile_travel_distance(double a, double v){ 
    double distance = v*v/G * sin(2*a);
    return distance;
}
       

double degree_to_radian(double d){    
    double radian = d * PI/180;
    return radian;
}

