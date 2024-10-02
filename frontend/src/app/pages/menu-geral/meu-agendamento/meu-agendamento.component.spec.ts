import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MeuAgendamentoComponent } from './meu-agendamento.component';

describe('MeuAgendamentoComponent', () => {
  let component: MeuAgendamentoComponent;
  let fixture: ComponentFixture<MeuAgendamentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MeuAgendamentoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MeuAgendamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
