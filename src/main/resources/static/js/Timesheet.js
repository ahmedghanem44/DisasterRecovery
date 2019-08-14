




class Timesheet extends React.Component
{
	constructor(props)
	{
		super(props);
		this.state = {"site_code":"", "contractor_name":"", "date":null, labor_info:[], machine_info:[]}
	}
	
	componentDidMount()
	{
		this.addLaborRow();
		this.addMachineRow();
	}
	
	render()
	{
		let labor_rows_to_render = this.state.labor_info.map((elem) => 
			TimeSheetRow(elem, "Labor Code: ", "Hours Worked: ", this.props.labor_opt));
		let machine_rows_to_render = this.state.machine_info.map((elem) => 
			TimeSheetRow(elem, "Machine Code: ", "Hours Used: ", this.props.machine_opt));
		return(
			<div style={{align:"center", paddingTop:"20px", margin:"0px", display:"block"}}>
				<div style={{marginBot:"10px", display:"inline-block"}}>
					<form style={{height:"30px", float:"left"}} onSubmit={function (e){e.preventDefault();}}>
						Site Code:
						<input style={{paddingRight:"5px", marginLeft:"10px", marginRight:"10px"}} type="text" 
						onChange={e => this.handleChangeVal("site_code", e)}
						/>
					</form>
					<form style={{height:"30px", float:"left"}} onSubmit={function (e){e.preventDefault();}}>
						Contractor Name:
						<input type="text" style={{marginLeft:"10px", marginRight:"10px"}}
						onChange={e => this.handleChangeVal("contractor_name", e)}
						/>
					</form>
					<form style={{height:"30px", float:"left"}} onSubmit={function (e){e.preventDefault();}}>
						Date:
						<input type="date" style={{marginLeft:"10px"}}
						onChange={e => this.handleChangeVal("date", e)}
						/>
					</form>
				</div>
				<div id="labor_input_container" style={{boxSizing:"border-box", backgroundColor:"#EEEEEE", 
					borderStyle:"solid", borderColor:"#AAAAAA", margin:"0px", padding:"0px"}}>
					<p style={{fontSize:"20px"}}>Labor Entry</p>
					<ul style={{listStyleType:"none", margin:"5px"}}>
						{labor_rows_to_render}
					</ul>
					<button style={{position:"static"}} onClick={this.addLaborRow}>Add More</button>		
				</div>	
				<div id="machine_input_container" style={{boxSizing:"border-box", backgroundColor:"#EEEEEE", 
					borderStyle:"solid", borderColor:"#AAAAAA", marginTop:"10px", padding:"0px"}}>
					<p style={{fontSize:"20px"}}>Machine Entry</p>
					<ul style={{listStyleType:"none", margin:"5px"}}>
						{machine_rows_to_render}
					</ul>
					<button style={{position:"static"}} onClick={this.addMachineRow}>Add More</button>	
				</div>	
				<button style={{position:"relative", left:"0px", marginTop:"10px"}} onClick={this.handleSubmit}>Submit</button>
			</div>
		)
	}
	
	addLaborRow = () =>
	{
		
		this.setState({
		  labor_info: [...this.state.labor_info, {"code":null, "hours":null, "total":null}]
		})
		console.log("adding a labor row")
	}
	addMachineRow = () =>
	{
		
		this.setState({
		  machine_info: [...this.state.machine_info, {"code":null, "hours":null, "total":null}]
		})
		console.log("adding a machine row")
	}
	
	handleSubmit = (e) =>
	{
		e.preventDefault();
		let labor_to_send = [];
		for(let i=0;i<this.state.labor_info.length;i++)
		{
			let elem = this.state.labor_info[i];
			console.log(elem);
			if(elem["code"] && elem["hours"] && elem["total"])
			{
				labor_to_send.push(elem);
				console.log("valid");
			}
		}
		let machines_to_send = [];
		for(let i=0;i<this.state.machine_info.length;i++)
		{
			let elem = this.state.machine_info[i];
			console.log(elem);
			if(elem["code"] && elem["hours"] && elem["total"])
			{
				machines_to_send.push(elem);
				console.log("valid");
			}
		}
	}	
	
	handleChangeVal(key, e)
	{
		e.preventDefault();
		this.setState({key:e.target.value})
	}
}



function TimeSheetRow (tsr, label1, label2, dd_opts)
{
	let dd_elements = dd_opts.map((elem) => <option value={elem}>{elem}</option>);
	return(
		<React.Fragment>
		<li>
			<div style={{padding:"0px", float:"none"}}>
				<p style={{float:"left"}}>{label1}</p>
				<select style={{float:"left", padding:"1px", marginLeft:"10px", marginRight:"10px"}} onChange={function (event){tsr["code"] = event.target.value;}}>
					<option value={null}></option>
					{dd_elements}
				</select>
				<form style={{float:"left"}} onSubmit={function (e){e.preventDefault();}}>
					{label2}
					<input style={{paddingRight:"5px", marginLeft:"10px", marginRight:"10px"}} type="number" 
					onChange={e => tsr["hours"] = e.target.value}
					/>
				</form>
				<form style={{height:"30px"}} onSubmit={function (e){e.preventDefault();}}>
					Total:
					<input type="number" style={{marginLeft:"10px"}}
					onChange={e => tsr["total"] = e.target.value}
					/>
				</form>
			</div>
		</li>
		
		</React.Fragment>
	)
}






ReactDOM.render(
	React.createElement(Timesheet, {labor_opt:labor_options_list, machine_opt:machine_options_list}),
	document.getElementById('timesheetRoot')
);



