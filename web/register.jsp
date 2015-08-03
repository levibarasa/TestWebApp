<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
        <link rel="stylesheet" type="text/css" href="style.css">
        <link rel="javascript" type="text/javascript" href="javascript.js">
        <title>Registration Page</title>	
    </head>
    <body>
    <center>
        <div id="mystyle" class="myform">
            <form id="form" name="form" method="post" action="RegisterServlet">
                <h1>Registration</h1>
                <p>Please enter the following information</p>

                <label>First Name
                    <span class="small">Enter your first name</span>
                </label>
                <input type="text" name="firstName" id="firstName" />

                <label>Last Name
                    <span class="small">Enter your last name</span>
                </label>
                <input type="text" name="middleName" id="middleName" />
                <label>Gender</label>
                <Select name="gender">
                    <option value="m">Male</option>
                    <option value="f">Female</option>
                </select>

                <input type="text" name="lastName" id="lastName" />

                <label>Email
                    <span class="small">Ex: yourmail12@gmail.com</span>
                </label>
                <input type="text" name="email" id="email" />

                <label>Phone
                    <span class="small">Enter your Phone Number</span>
                </label>
                <div id="application" role="application">
                    <label id="date_label" for="date">Date Of Birth</label>:
                    <input id="date" type="text" name="dob"/>
                    <button id="bn_date">Select DOB...</button> 
                    <div id="dp1" class="datepicker" aria-hidden="true">
                        <div id="month-wrap">
                            <div id="bn_prev" role="button" aria-labelledby="bn_prev-label" tabindex="0"><img class="bn_img" src="http://www.oaa-accessibility.org/media/examples/images/prev.png" alt="<<"/></div>
                            <div id="month" role="heading" aria-live="assertive" aria-atomic="true">February 2011</div>
                            <div id="bn_next" role="button" aria-labelledby="bn_next-label" tabindex="0"><img class="bn_img" src="http://www.oaa-accessibility.org/media/examples/images/next.png" alt=">>"/></div>
                        </div>
                        <table id="cal" role="grid" aria-activedescendant="errMsg" aria-labelledby="month" tabindex="0">
                            <thead>
                                <tr id="weekdays">
                                    <th id="Sunday"><abbr title="Sunday">Su</abbr></th>
                                    <th id="Monday"><abbr title="Monday">Mo</abbr></th>
                                    <th id="Tuesday"><abbr title="Tuesday">Tu</abbr></th>
                                    <th id="Wednesday"><abbr title="Wednesday">We</abbr></th>
                                    <th id="Thursday"><abbr title="Thursday">Th</abbr></th>
                                    <th id="Friday"><abbr title="Friday">Fr</abbr></th>
                                    <th id="Saturday"><abbr title="Saturday">Sa</abbr></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr><td id="errMsg" colspan="7">Javascript must be enabled</td></tr>
                            </tbody>
                        </table>
                        <div id="bn_prev-label" class="offscreen">Go to previous month</div>
                        <div id="bn_next-label" class="offscreen">Go to next month</div>
                    </div>
                </div>

                <label>Password
                    <span class="small">Password min. 6 chars</span>
                </label>
                <input type="text" name="password" id="password" />
                <label>Password Again
                    <span class="small">Password min. 6 chars</span>
                </label>
                <input type="text" name="password" id="password" />

                <button type="submit">Register</button>
                <div class="spacer"></div>

            </form>
        </div>
    </center>
</body>
</html>
