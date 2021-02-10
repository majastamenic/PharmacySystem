import { Component, OnInit } from '@angular/core';
import { CalendarOptions, DateSelectArg, EventClickArg, EventApi, EventInput } from '@fullcalendar/angular';
import { createEventId} from 'src/app/event-utils';
import { VacationScheduleService } from 'src/app/service/vacation-schedule.service';

const TODAY_STR = new Date().toISOString().replace(/T.*$/, ''); // YYYY-MM-DD of today

@Component({
  selector: 'app-work-schedule',
  templateUrl: './work-schedule.component.html',
  styleUrls: ['./work-schedule.component.css']
})
export class WorkScheduleComponent implements OnInit {

  INITIAL_EVENTS: EventInput[] = [];
  currentEvents: EventApi[] = [];
  vacations: any[]=[];
  calendarVisible = true;

  constructor(private vacationService: VacationScheduleService) {
    
   }

  ngOnInit(): void {
    let loggedUser = sessionStorage.getItem("user");

    if(loggedUser){
      this.vacationService.getDermatologistVacations(loggedUser).subscribe((data: any[]) => {
        this.vacations = data;
        console.log(this.vacations);
        for (var i of this.vacations) {
          this.INITIAL_EVENTS.push({
            id: createEventId(),
            title: 'Vacation',
            start: i.startDate,
            end: i.endDate,
            allDay: true,
            backgroundColor: 'yellow',
            display: 'background'
          })
          this.calendarOptions.events = this.INITIAL_EVENTS;
        }
      });
    }
  }


  calendarOptions: CalendarOptions = {
    headerToolbar: {
      left: 'prev,next today',
      center: 'title',
      right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
    },
    initialView: 'dayGridMonth',
    weekends: true,
    editable: true,
    selectable: true,
    selectMirror: true,
    dayMaxEvents: true,
    select: this.handleDateSelect.bind(this),
    eventClick: this.handleEventClick.bind(this),
    eventsSet: this.handleEvents.bind(this)
  };
  

  handleCalendarToggle() {
    this.calendarVisible = !this.calendarVisible;
  }

  handleWeekendsToggle() {
    const { calendarOptions } = this;
    calendarOptions.weekends = !calendarOptions.weekends;
  }

  handleDateSelect(selectInfo: DateSelectArg) {
    const title = prompt('Please enter a new title for your event');
    const calendarApi = selectInfo.view.calendar;

    calendarApi.unselect();

    if (title) {
      calendarApi.addEvent({
        id: createEventId(),
        title,
        start: selectInfo.startStr,
        end: selectInfo.endStr,
        allDay: selectInfo.allDay
      });
    }
  }

  handleEventClick(clickInfo: EventClickArg) {
    if (confirm(`Are you sure you want to delete the event '${clickInfo.event.title}'`)) {
      clickInfo.event.remove();
    }
  }

  handleEvents(events: EventApi[]) {
    this.currentEvents = events;
  }

  

  

}

