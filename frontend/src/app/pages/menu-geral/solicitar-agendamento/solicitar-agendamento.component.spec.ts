import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SolicitarAgendamentoComponent } from './solicitar-agendamento.component';

describe('SolicitarAgendamentoComponent', () => {
  let component: SolicitarAgendamentoComponent;
  let fixture: ComponentFixture<SolicitarAgendamentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SolicitarAgendamentoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SolicitarAgendamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
